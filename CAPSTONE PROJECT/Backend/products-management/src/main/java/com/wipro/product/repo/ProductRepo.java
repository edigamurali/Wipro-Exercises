package com.wipro.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.product.entity.Product;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);

    // Search by name containing text (case-insensitive)
    List<Product> findByNameContainingIgnoreCase(String name);

    // Combined filter (both category and name)
    List<Product> findByCategoryAndNameContainingIgnoreCase(String category, String name);
}
