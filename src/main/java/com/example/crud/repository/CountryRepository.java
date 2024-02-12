package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
