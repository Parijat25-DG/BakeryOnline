package com.spring.postgresql.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.postgresql.api.model.Parties;

@Repository
public interface PartyRepository extends JpaRepository<Parties, Long>{
	
	@Query("FROM PARTIES")
    public List<Parties> getAll();
	
	@Query("FROM PARTIES")
    public Parties findByPartyId(int id);
	
	@Query("FROM PARTIES")
    public List<Parties> findByType(String typeOfParty);

}
