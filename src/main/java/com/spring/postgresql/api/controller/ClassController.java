package com.spring.postgresql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgresql.api.model.Classes;
import com.spring.postgresql.api.repository.ClassRepository;

@RestController
@RequestMapping("/api")
public class ClassController {
	
	@Autowired
	private ClassRepository classRepository;
	
	@GetMapping("/getAllClasses")
	public List<Classes> findAllClasses(){
		return classRepository.findAll();
	}
	
	@GetMapping("/getClassesByCuisine/{cuisine}")
	public List<Classes> findClassesByCuisine(@PathVariable String cuisine){
		return classRepository.findByCuisine(cuisine);
	}
	
	@GetMapping("/getClassesByCuisine/{location}")
	public List<Classes> findClassesByLocation(@PathVariable String location){
		return classRepository.findByLocation(location);
	}

}
