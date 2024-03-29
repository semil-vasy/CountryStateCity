package com.example.crud.repository;

import java.util.List;

import com.example.crud.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.State;

public interface StateRepository extends JpaRepository<State, Long> {
//	@Query(value = "SELECT * FROM state s WHERE s.country_id = :countryId", nativeQuery = true)
	public List<State> findByCountry(Country country);
}
