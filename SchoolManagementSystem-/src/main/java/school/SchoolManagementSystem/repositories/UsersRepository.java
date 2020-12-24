package school.SchoolManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.SchoolManagementSystem.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
