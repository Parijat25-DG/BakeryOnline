package com.spring.postgresql.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.postgresql.api.model.Classes;

@Repository
public interface ClassRepository extends JpaRepository<Classes, Long>{
	
	@Query("FROM CLASSES")
    public List<Classes> getAll();
	
	@Query("FROM CLASSES")
    public Classes findByClassId(int id);
	
	@Query("FROM CLASSES")
    public List<Classes> findByCuisine(String cuisine);
	
	@Query("FROM CLASSES")
    public List<Classes> findByLocation(String location);

}
