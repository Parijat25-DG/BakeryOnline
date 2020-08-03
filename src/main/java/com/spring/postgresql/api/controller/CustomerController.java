package com.spring.postgresql.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgresql.api.model.Customer;
import com.spring.postgresql.api.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/getCustomerDetails/{name}/{email}")
	public Customer fetchCustomerDetails(@PathVariable(value="name") String name, @PathVariable(value="email")String email){
		return customerRepository.findByNameAndEmail(name, email);
	}
	
	@PostMapping("/saveCustomerDetails")
	public int saveCustomerDetails(@RequestBody Customer customer) {
		return customerRepository.save(customer).getId();
	}

}
