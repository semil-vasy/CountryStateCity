package com.example.crud.repository;

import java.util.List;

import com.example.crud.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crud.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
//	@Query(value = "SELECT * FROM city c WHERE c.state_id = :stateId", nativeQuery = true)
	public List<City> findByState(State state);
}
