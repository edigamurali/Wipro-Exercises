package com.wipro.product.service;

import java.util.List;
import com.wipro.product.entity.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
