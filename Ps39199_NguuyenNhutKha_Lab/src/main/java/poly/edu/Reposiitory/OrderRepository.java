package poly.edu.Reposiitory;
import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.Entity.Lab6.*;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Additional query methods (if needed) can be added here
}