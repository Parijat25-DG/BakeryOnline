package com.spring.postgresql.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.postgresql.api.model.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long>{
	
	@Query("FROM ITEMS")
    public List<Items> getAll();
	
	@Query("FROM ITEMS")
    public Items findByItemId(int id);
	
	@Query("FROM ITEMS")
    public List<Items> findByCuisine(String cuisine);
	
	@Query("FROM ITEMS")
    public Items findByName(String name);
	
}
