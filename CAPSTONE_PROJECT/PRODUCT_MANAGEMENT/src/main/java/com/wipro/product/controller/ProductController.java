package com.wipro.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.product.entity.Product;
import com.wipro.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // USER or ADMIN can view products
    @GetMapping("/user")
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.findById(id);
    }

    // ADMIN only
    @PostMapping("/admin")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.save(product));
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok(service.save(product));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Product deleted with id " + id);
    }
}
