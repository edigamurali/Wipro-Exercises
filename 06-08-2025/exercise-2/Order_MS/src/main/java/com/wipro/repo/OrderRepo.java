package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.wipro.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
