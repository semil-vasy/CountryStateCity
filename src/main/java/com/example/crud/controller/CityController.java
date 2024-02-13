package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud.dto.ApiResponse;
import com.example.crud.dto.CityDto;
import com.example.crud.service.CityService;

@RestController
@RequestMapping("api")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/city")
	public ResponseEntity<List<CityDto>> getAllCities() {
		List<CityDto> cities = cityService.getAllCity();
		return ResponseEntity.ok(cities);
	}

	@GetMapping("/{cityId}")
	public ResponseEntity<CityDto> getCityById(@PathVariable long cityId) {
		CityDto city = cityService.getCityById(cityId);
		return ResponseEntity.ok(city);
	}

	@GetMapping("/state/{stateId}/city")
	public ResponseEntity<List<CityDto>> getCityByStateId(@PathVariable Long stateId) {
		List<CityDto> cities = cityService.getCityByStateId(stateId);
		return ResponseEntity.ok(cities);
	}

	@PostMapping("/state/{stateId}/city")
	public ResponseEntity<CityDto> addCity(@PathVariable long stateId, @RequestBody CityDto cityDto) {
		CityDto createdCity = cityService.addCity(stateId, cityDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
	}

	@PutMapping("/city/{cityId}")
	public ResponseEntity<CityDto> updateCity(@PathVariable long cityId, @RequestBody CityDto cityDto) {
		CityDto updatedCity = cityService.updateCity(cityId, cityDto);
		return ResponseEntity.ok(updatedCity);
	}

	@DeleteMapping("/city/{cityId}")
	public ResponseEntity<ApiResponse> deleteCity(@PathVariable long cityId) {
		cityService.deleteCity(cityId);
		return ResponseEntity.ok(new ApiResponse(200, "Success", "State deleted Successfully"));
	}
}
