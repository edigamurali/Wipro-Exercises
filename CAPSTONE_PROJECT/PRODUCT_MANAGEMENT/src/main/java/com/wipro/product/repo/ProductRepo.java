package com.wipro.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.product.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
