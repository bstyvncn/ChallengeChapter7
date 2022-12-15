package chapter4.service;


import chapter4.model.UserDetailsImpl;
import chapter4.model.users;
import chapter4.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    userRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users user = usersRepository.findByUsername(username).orElseGet(null);
        // do something
        return UserDetailsImpl.build(user);
    }


}
