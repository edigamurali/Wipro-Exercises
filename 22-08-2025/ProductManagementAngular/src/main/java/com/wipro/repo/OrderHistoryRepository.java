package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.entity.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {}
