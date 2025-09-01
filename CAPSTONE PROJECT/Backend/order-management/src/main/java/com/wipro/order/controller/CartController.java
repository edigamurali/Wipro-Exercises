package com.wipro.order.controller;

import com.wipro.order.entity.CartItem;
import com.wipro.order.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/cart")
@Tag(name = "Cart Management", description = "APIs for shopping cart operations")
public class CartController {
    private final CartService service;
    
    public CartController(CartService service){ 
        this.service = service; 
    }

    @PostMapping("/addProd")
    @Operation(summary = "Add product to cart")
    public ResponseEntity<CartItem> add(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer qty){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Add to cart - User: " + auth.getName() + " Authorities: " + auth.getAuthorities());
        return ResponseEntity.ok(service.add(userId, productId, qty));
    }

    @DeleteMapping("/deleteProd/{id}")
    @Operation(summary = "Remove product from cart")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Delete from cart - User: " + auth.getName());
        service.delete(id);
        return ResponseEntity.ok("Deleted item " + id);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update product quantity in cart")
    public ResponseEntity<CartItem> update(@PathVariable Long id, @RequestParam Integer qty){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Update cart - User: " + auth.getName());
        return ResponseEntity.ok(service.update(id, qty));
    }

    @GetMapping("/{userId}")
    @Operation(summary = "View user's cart")
    public ResponseEntity<List<CartItem>> list(@PathVariable Long userId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Get cart - User: " + auth.getName());
        return ResponseEntity.ok(service.list(userId));
    }
}
