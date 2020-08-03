package com.spring.postgresql.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.postgresql.api.model.Shops;

@Repository
public interface ShopRepository extends JpaRepository<Shops, Long>{
	
	@Query("FROM SHOPS")
    public List<Shops> getAll();
	
	@Query("FROM SHOPS")
    public Shops findByShopId(int id);

	@Query("FROM SHOPS")
    public Shops findByShopLocation(String location);
	
}
