package com.wipro.product.service;

import com.wipro.product.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    List<Product> findByCategory(String category);
    List<Product> searchByName(String name);
    List<Product> filterByCategoryAndName(String category, String name);
}