package com.spring.postgresql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgresql.api.model.Items;
import com.spring.postgresql.api.repository.ItemRepository;

@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/getAllItems")
	public List<Items> findAllItems(){
		return itemRepository.findAll();
	}
	
	@GetMapping("/getItemsByCuisine/{cuisine}")
	public List<Items> findItemsByCuisine(@PathVariable String cuisine){
		return itemRepository.findByCuisine(cuisine);
	}
	
}
