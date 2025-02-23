package poly.edu.Reposiitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.edu.Entity.Lab6.*;



public interface CartRepository extends JpaRepository<Cart, Long>  {
	 	@Query("SELECT c FROM Cart c WHERE c.user.userId = :userId AND c.product.id = :productId")
	    Cart getCartByUserAndProduct(@Param("userId") Integer userId, 
	                                           @Param("productId") Long productId);
}