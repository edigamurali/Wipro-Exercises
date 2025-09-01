package com.wipro.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.product.entity.Product;
import com.wipro.product.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = repo.findById(id);
        return product.orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public void deleteById(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Product not found with id " + id);
        }
        repo.deleteById(id);
    }
    @Override
    public List<Product> findByCategory(String category) {
        return repo.findByCategory(category);
    }
    @Override
    public List<Product> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> filterByCategoryAndName(String category, String name) {
        return repo.findByCategoryAndNameContainingIgnoreCase(category, name);
    }

}