package com.example.crud.service;

import java.util.List;

import com.example.crud.dto.CountryDto;

public interface CountryService {

	List<CountryDto> getAllCountries();

	CountryDto getCountryById(long countryId);

	CountryDto addCountry(CountryDto countryDto);

	void deleteCountry(long countryId);

	CountryDto updateCountry(long countryId, CountryDto countryDto);

}
