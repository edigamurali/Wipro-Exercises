package com.wipro.order.service;

import com.wipro.order.entity.CartItem;
import com.wipro.order.repo.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

import java.util.List;

@Service
public class CartService {
    private final CartItemRepo repo;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private HttpServletRequest request;
    
    public CartService(CartItemRepo repo){ 
        this.repo = repo; 
    }

 // Replace your add() method with this fixed version:

    public CartItem add(Long userId, Long productId, Integer qty){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Adding to cart - User: " + auth.getName() + " for userId: " + userId);
        
        if (qty <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }
        
        // Fetch product details from Product Service
        Product product = fetchProductDetails(productId);
        if (product == null) {
            throw new RuntimeException("Product not found with id: " + productId);
        }
        
        // Check if item already exists in cart
        List<CartItem> existingItems = repo.findByUserId(userId);
        for (CartItem item : existingItems) {
            if (item.getProductId().equals(productId)) {
                // Update quantity AND refresh product details
                item.setQuantity(item.getQuantity() + qty);
                item.setProductName(product.getName());
                item.setProductImage(product.getImage());
                item.setProductPrice(product.getPrice());
                System.out.println("Updated existing cart item quantity to: " + item.getQuantity());
                return repo.save(item);
            }
        }
        
        // Create new cart item with product details
        CartItem ci = new CartItem();
        ci.setUserId(userId);
        ci.setProductId(productId);
        ci.setQuantity(qty);
        ci.setProductName(product.getName());
        ci.setProductImage(product.getImage());
        ci.setProductPrice(product.getPrice());
        
        System.out.println("Created new cart item for product: " + productId + " with quantity: " + qty);
        return repo.save(ci);
    }
    public void delete(Long itemId){ 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Deleting cart item: " + itemId + " - User: " + auth.getName());
        
        if (!repo.existsById(itemId)) {
            throw new RuntimeException("Cart item not found with id: " + itemId);
        }
        repo.deleteById(itemId); 
    }

    public CartItem update(Long itemId, Integer qty){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Updating cart item: " + itemId + " to quantity: " + qty + " - User: " + auth.getName());
        
        if (qty <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }
        
        CartItem ci = repo.findById(itemId).orElseThrow(() -> new RuntimeException("Cart item not found with id: " + itemId));
        ci.setQuantity(qty);
        
        // Refresh product details (in case price or other details changed)
        Product product = fetchProductDetails(ci.getProductId());
        if (product != null) {
            ci.setProductName(product.getName());
            ci.setProductImage(product.getImage());
            ci.setProductPrice(product.getPrice());
        }
        
        return repo.save(ci);
    }

    public List<CartItem> list(Long userId){ 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Getting cart for userId: " + userId + " - User: " + auth.getName());
        return repo.findByUserId(userId); 
    }
    
    private Product fetchProductDetails(Long productId) {
        try {
            String authHeader = request.getHeader("Authorization");
            HttpHeaders headers = new HttpHeaders();
            if (authHeader != null) {
                headers.set("Authorization", authHeader);
            }
            
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<Product> response = restTemplate.exchange(
                "http://localhost:9001/products/" + productId,
                HttpMethod.GET,
                entity,
                Product.class
            );
            
            return response.getBody();
        } catch (Exception e) {
            System.out.println("Error fetching product details for productId " + productId + ": " + e.getMessage());
            return null;
        }
    }
    
    // Inner class for Product response
    @Data
    public static class Product {
        private Long id;
        private String name;
        private String description;
        private Double price;
        private Integer stock;
        private String category;
        private String image;
        
    }
}