package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud.dto.CityDto;
import com.example.crud.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping
	public ResponseEntity<List<CityDto>> getAllCities() {
		List<CityDto> cities = cityService.getAllCity();
		return ResponseEntity.ok(cities);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CityDto> getCityById(@PathVariable Long id) {
		CityDto city = cityService.getCityById(id);
		return ResponseEntity.ok(city);
	}

	@PostMapping
	public ResponseEntity<CityDto> createCity(@RequestBody CityDto city) {
		CityDto createdCity = cityService.addCity(city);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CityDto> updateCity(@PathVariable Long id, @RequestBody CityDto city) {

		CityDto updatedCity = cityService.updateCity(id, city);
		return ResponseEntity.ok(updatedCity);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCity(@PathVariable Long id) {

		cityService.deleteCity(id);
		return ResponseEntity.noContent().build();

	}
}
