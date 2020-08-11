package com.spring.postgresql.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.postgresql.api.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query("FROM ORDERS")
    public Order findByOrderId(int orderId);

}
