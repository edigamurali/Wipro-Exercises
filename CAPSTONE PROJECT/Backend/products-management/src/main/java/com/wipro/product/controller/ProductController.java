package com.wipro.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.product.entity.Product;
import com.wipro.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/products")
@Tag(name = "Product Management", description = "APIs for product catalog management")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    @Operation(summary = "Get all products (requires authentication)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
        @ApiResponse(responseCode = "401", description = "Unauthorized - JWT token required"),
        @ApiResponse(responseCode = "403", description = "Forbidden - Invalid token or insufficient permissions")
    })
    public ResponseEntity<List<Product>> getAllProducts() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Getting all products - User: " + auth.getName() + " Authorities: " + auth.getAuthorities());
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID (requires authentication)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product found"),
        @ApiResponse(responseCode = "404", description = "Product not found"),
        @ApiResponse(responseCode = "401", description = "Unauthorized - JWT token required")
    })
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Getting product by ID: " + id + " - User: " + auth.getName());
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Add new product (admin only)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid product data"),
        @ApiResponse(responseCode = "403", description = "Access denied - Admin role required")
    })
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Adding new product - User: " + auth.getName() + " Authorities: " + auth.getAuthorities());
        return ResponseEntity.ok(service.save(product));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Update product (admin only)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product updated successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found"),
        @ApiResponse(responseCode = "403", description = "Access denied - Admin role required")
    })
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Updating product ID: " + id + " - User: " + auth.getName());
        product.setId(id);
        return ResponseEntity.ok(service.save(product));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Delete product (admin only)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found"),
        @ApiResponse(responseCode = "403", description = "Access denied - Admin role required")
    })
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Deleting product ID: " + id + " - User: " + auth.getName());
        service.deleteById(id);
        return ResponseEntity.ok("Product deleted with id " + id);
    }

    @PutMapping("/stock/{id}")
    @Operation(summary = "Update product stock (internal)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Stock updated successfully"),
        @ApiResponse(responseCode = "400", description = "Insufficient stock"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<Product> updateStock(@PathVariable Long id, @RequestParam int delta) {
        System.out.println("Updating stock for product ID: " + id + " with delta: " + delta);
        Product product = service.findById(id);
        int newStock = product.getStock() + delta;
        if (newStock < 0) {
            throw new RuntimeException("Insufficient stock for product " + id);
        }
        product.setStock(newStock);
        return ResponseEntity.ok(service.save(product));
    }
    @GetMapping("/search")
    @Operation(summary = "Search products by category and/or name")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String name) {

        if (category != null && name != null) {
            return ResponseEntity.ok(service.filterByCategoryAndName(category, name));
        } else if (category != null) {
            return ResponseEntity.ok(service.findByCategory(category));
        } else if (name != null) {
            return ResponseEntity.ok(service.searchByName(name));
        } else {
            return ResponseEntity.ok(service.findAll());
        }
    }


}