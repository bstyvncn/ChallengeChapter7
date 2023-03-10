package chapter4.repositories;

import chapter4.model.UserActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActiveRepository extends JpaRepository<UserActive, Integer> {
}

