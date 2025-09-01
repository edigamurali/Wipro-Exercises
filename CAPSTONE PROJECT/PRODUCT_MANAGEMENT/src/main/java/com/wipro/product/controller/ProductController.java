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

    // PUBLIC (no auth)
    @GetMapping("/public")
    public List<Product> getAllPublicProducts() {
        return service.findAll();
    }

    @GetMapping("/public/{id}")
    public Product getPublicProductById(@PathVariable Long id) {
        return service.findById(id);
    }

    // USER or ADMIN
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

    // STOCK UPDATE for Order MS
    @PutMapping("/admin/stock/{id}")
    public ResponseEntity<Product> updateStock(@PathVariable Long id, @RequestParam int delta) {
        Product product = service.findById(id);
        int newStock = product.getStock() + delta;
        if (newStock < 0) {
            throw new RuntimeException("Insufficient stock for product " + id);
        }
        product.setStock(newStock);
        return ResponseEntity.ok(service.save(product));
    }
}
