package com.example.crud.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dto.CountryDto;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Country;
import com.example.crud.repository.CountryRepository;
import com.example.crud.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CountryDto> getAllCountries() {
		List<Country> countries = countryRepository.findAll();
		return countries.stream().map(this::countryToDto).toList();
	}

	@Override
	public CountryDto getCountryById(long countryId) {
		Country country = countryRepository.findById(countryId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No id found : " + countryId));
		return this.countryToDto(country);
	}

	@Override
	public CountryDto addCountry(CountryDto countryDto) {
		Country country = countryRepository.save(this.dtoToCountry(countryDto));
		return this.countryToDto(country);
	}

	@Override
	public void deleteCountry(long countryId) {
		countryRepository.findById(countryId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No id found : " + countryId));
		countryRepository.deleteById(countryId);
	}

	@Override
	public CountryDto updateCountry(long countryId, CountryDto countryDto) {
		Country country = countryRepository.findById(countryId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No id found : " + countryId));
		
		country.setCountryName(countryDto.getCountryName());
		
		Country newCountry = countryRepository.save(country);
		return this.countryToDto(newCountry);
	}

	Country dtoToCountry(CountryDto countryDto) {
		return this.modelMapper.map(countryDto, Country.class);
	}

	CountryDto countryToDto(Country country) {
		return this.modelMapper.map(country, CountryDto.class);
	}

}
