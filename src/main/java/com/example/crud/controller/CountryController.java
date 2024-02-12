package com.example.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.dto.ApiResponse;
import com.example.crud.dto.CountryDto;
import com.example.crud.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping
	public ResponseEntity<List<CountryDto>> getAllCountries() {
		List<CountryDto> countries = countryService.getAllCountries();
		return ResponseEntity.ok(countries);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id) {
		CountryDto countryDto = countryService.getCountryById(id);
		return ResponseEntity.ok(countryDto);
	}

	@PostMapping
	public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
		CountryDto savedCountry = countryService.addCountry(countryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CountryDto> updateCountry(@PathVariable Long countryId, @RequestBody CountryDto countryDto) {

		CountryDto updatedCountry = countryService.updateCountry(countryId, countryDto);
		return ResponseEntity.ok(updatedCountry);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCountry(@PathVariable Long countryId) {
		countryService.deleteCountry(countryId);
		return ResponseEntity.ok(new ApiResponse(200, "Success", "COuntry Deleted"));
	}
}
