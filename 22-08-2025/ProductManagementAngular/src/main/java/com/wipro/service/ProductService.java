package com.wipro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.entity.Product;
import com.wipro.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll() { return productRepo.findAll(); }

    public Product findById(Integer id) { return productRepo.findById(id).orElse(null); }

    public Product save(Product product) {
        if (product.getQty() == null || product.getQty() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        return productRepo.save(product);
    }

    public void deleteById(Integer id) { productRepo.deleteById(id); }
}
