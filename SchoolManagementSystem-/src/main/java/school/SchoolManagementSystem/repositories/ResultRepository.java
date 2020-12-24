package school.SchoolManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.SchoolManagementSystem.model.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {
}
