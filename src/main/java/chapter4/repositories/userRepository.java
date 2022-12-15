package chapter4.repositories;

import chapter4.model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository <users, String>{

    @Query(value = "select * from users where username = :username and password = :password", nativeQuery = true)
    public List<users> findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query(value = "DELETE FROM users WHERE username = :username;", nativeQuery = true)
    public void deleteUser(@Param("username") String username);

    @Modifying
    @Procedure("change_username")
    public void changeUsername(String usernameFrom, String usernameTo);

    Optional<users> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);


}
