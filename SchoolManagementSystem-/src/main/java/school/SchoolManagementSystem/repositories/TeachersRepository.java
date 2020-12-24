package school.SchoolManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.SchoolManagementSystem.model.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers, Integer> {
}
