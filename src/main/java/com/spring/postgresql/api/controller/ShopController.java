package com.spring.postgresql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgresql.api.model.Shops;
import com.spring.postgresql.api.repository.ShopRepository;

@RestController
@RequestMapping("/api")
public class ShopController {
	
	@Autowired
	private ShopRepository shopRepository;
	
	@GetMapping("/getAllShops")
	public List<Shops> findAllShops(){
		return shopRepository.findAll();
	}
	
	@GetMapping("/findShopByLocation/{location}")
	public Shops findShopByLocation(@PathVariable String location) {
		return shopRepository.findByShopLocation(location);
	}

}
