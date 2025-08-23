package com.wipro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wipro.entity.Product;
import com.wipro.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired private ProductService productService;

    @GetMapping public List<Product> getAllProducts() { return productService.findAll(); }

    @GetMapping("/{id}") public Product getProduct(@PathVariable Integer id) { return productService.findById(id); }

    @PostMapping public Product addProduct(@RequestBody Product product) { return productService.save(product); }

    @PutMapping public Product updateProduct(@RequestBody Product product) { return productService.save(product); }

    @DeleteMapping("/{id}") public void deleteProduct(@PathVariable Integer id) { productService.deleteById(id); }
}
