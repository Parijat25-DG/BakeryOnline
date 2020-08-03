package com.spring.postgresql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgresql.api.model.Parties;
import com.spring.postgresql.api.repository.PartyRepository;

@RestController
@RequestMapping("/api")
public class PartyController {
	
	@Autowired
	private PartyRepository partyRepository;
	
	@GetMapping("/getAllParties")
	public List<Parties> findAllParties(){
		return partyRepository.findAll();
	}
	
	@GetMapping("/getPartiesByType/{typeOfParty}")
	public List<Parties> findPartiesByType(@PathVariable String typeOfParty){
		return partyRepository.findByType(typeOfParty);
	}

}
