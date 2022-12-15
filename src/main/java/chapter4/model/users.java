package chapter4.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table( name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@NoArgsConstructor

public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username")
    private String username;

    private String email;
    private String address;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "userxrole",
            joinColumns = @JoinColumn(name ="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public users(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
