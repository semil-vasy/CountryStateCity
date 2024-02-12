package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crud.model.City;
import com.example.crud.model.State;

public interface CityRepository extends JpaRepository<City, Long> {
	@Query(value = "SELECT b FROM City b WHERE b.state_id = :stateId", nativeQuery = true)
	public List<City> findByStateId(Long stateId);
}
