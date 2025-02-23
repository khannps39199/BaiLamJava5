package poly.edu.Reposiitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.edu.Entity.Lab6.*;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Products WHERE price BETWEEN :minPrice AND :maxPrice", nativeQuery = true)
    Page<Product> findProductsByPriceRangeNative(
        @Param("minPrice") Double minPrice, 
        @Param("maxPrice") Double maxPrice, 
        Pageable pageable
    );
    Page<Product> findByPriceBetween(double minPrice, double maxPrice,Pageable pageable);

    @Query("SELECT o.category AS group, sum(o.price) AS sum, count(o) AS count "
            + " FROM Product o "
            + " GROUP BY o.category"
            + " ORDER BY sum(o.price) DESC")
    List<report> getTonKho();
    
    
    Page<Product> findByCategory_IdAndPriceBetween(Long id, Double minPrice, Double maxPrice, Pageable pageable);
    Page<Product> findByCategory_Id(Long id, Pageable pageable);
    
    @Query(value = "SELECT * FROM Products WHERE name LIKE %:keyword%", nativeQuery = true)
    Page<Product> findByKeywords(@Param("keyword") String name, Pageable pageable);
    
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

}

