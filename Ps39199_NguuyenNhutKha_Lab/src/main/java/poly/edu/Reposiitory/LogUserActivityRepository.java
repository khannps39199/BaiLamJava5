package poly.edu.Reposiitory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.Entity.Lab6.*;

public interface LogUserActivityRepository extends JpaRepository<LogUserActivities, Integer> {
    // Find all activities for a specific user
    List<LogUserActivities> findByUserUserId(Integer userId);

    // Find by token
    LogUserActivities findByToken(String token);
}