package poly.edu.Reposiitory;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.Entity.Lab6.*;


public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Integer> {
    // Additional query methods (if needed) can be added here
}