package school.SchoolManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.SchoolManagementSystem.model.Students;

import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Students, Integer> {


}
