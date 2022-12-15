package chapter4.configuration;


import chapter4.model.ENumeration.ERoles;
import chapter4.model.Role;
import chapter4.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private static final Logger LOG = LoggerFactory.getLogger(Config.class);

    Config(RoleRepository roleRepository) {
        LOG.info("Cheking roles presented");
        for(ERoles c : ERoles.values()) {
            try {
                Role roles = roleRepository.findByName(c)
                        .orElseThrow(() -> new RuntimeException("Roles not found"));
                LOG.info("Role {} has been found!", roles.getName());
            } catch(RuntimeException rte) {
                LOG.info("Role {} is not found, inserting to DB . . .", c.name());
                Role roles = new Role();
                roles.setName(c);
                roleRepository.save(roles);
            }
        }
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/film-service/**")
                        .uri("${FILM_SERVICE_HOST}"))
                .route(r -> r.path("/book-film-service/**")
                        .uri("${BOOK_FILM_SERVICE_HOST}"))
                .route(r -> r.path("/schedule/**")
                        .uri("${SCHEDULE_HOST}"))
                .route(r -> r.path("/seats/**")
                        .uri("${SEATS_HOST}"))
                .build();
    }


}

