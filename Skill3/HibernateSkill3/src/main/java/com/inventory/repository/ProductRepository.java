package com.inventory.repository;

import com.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Sorting
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByOrderByQuantityDesc();

    // Pagination handled later in service

    // Aggregate
    @Query("SELECT COUNT(p) FROM Product p")
    long countAllProducts();

    @Query("SELECT COUNT(p) FROM Product p WHERE p.quantity > 0")
    long countAvailableProducts();

    @Query("SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description")
    List<Object[]> countByDescription();

    @Query("SELECT MIN(p.price), MAX(p.price) FROM Product p")
    Object[] findMinMaxPrice();

    // WHERE
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPriceRange(double min, double max);

    // LIKE
    @Query("SELECT p FROM Product p WHERE p.name LIKE ?1%")
    List<Product> startsWith(String prefix);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1")
    List<Product> endsWith(String suffix);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> containsText(String text);
}