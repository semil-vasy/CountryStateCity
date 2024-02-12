package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crud.model.State;

public interface StateRepository extends JpaRepository<State, Long> {
	@Query(value = "SELECT b FROM State b WHERE b.country_id = :countryId", nativeQuery = true)
	public List<State> findByCountryId(Long countryId);
}
