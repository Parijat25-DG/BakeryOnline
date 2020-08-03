package com.spring.postgresql.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.postgresql.api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("FROM CUSTOMER")
    public Customer findByNameAndEmail(String name, String email);
	
	@Query("FROM CUSTOMER")
    public Customer findByCustomerId(int id);

}
