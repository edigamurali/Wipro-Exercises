package com.wipro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dto.OrderRequest;
import com.wipro.dto.OrderResponse;
import com.wipro.entity.OrderHistory;
import com.wipro.entity.Product;
import com.wipro.repo.OrderHistoryRepository;
import com.wipro.repo.ProductRepo;

@Service
public class OrderService {

    @Autowired private ProductRepo productRepo;
    @Autowired private OrderHistoryRepository orderRepo;

    @Transactional
    public OrderResponse placeOrder(OrderRequest req) {
        if (req.getProductId() == null) throw new IllegalArgumentException("productId is required");
        if (req.getQty() == null || req.getQty() <= 0) throw new IllegalArgumentException("qty must be > 0");

        Product product = productRepo.findById(req.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (req.getQty() > product.getQty()) {
            throw new IllegalArgumentException("Insufficient stock. Available: " + product.getQty());
        }

        // reduce stock
        product.setQty(product.getQty() - req.getQty());
        productRepo.saveAndFlush(product); // will throw ObjectOptimisticLockingFailureException if race

        OrderHistory order = new OrderHistory();
        order.setProduct(product);
        order.setQty(req.getQty());
        orderRepo.save(order);

        OrderResponse resp = new OrderResponse();
        resp.setId(order.getId());
        resp.setProductName(product.getName());
        resp.setQty(order.getQty());
        resp.setOrderDate(order.getOrderDate());
        return resp;
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepo.findAll().stream().map(order -> {
            OrderResponse resp = new OrderResponse();
            resp.setId(order.getId());
            resp.setProductName(order.getProduct().getName());
            resp.setQty(order.getQty());
            resp.setOrderDate(order.getOrderDate());
            return resp;
        }).collect(Collectors.toList());
    }
}
