package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud.dto.ApiResponse;
import com.example.crud.dto.StateDto;
import com.example.crud.service.StateService;

import java.util.List;

@RestController
@RequestMapping("api")
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping("/state")
	public ResponseEntity<List<StateDto>> getAllStates() {
		List<StateDto> states = stateService.getAllState();
		return ResponseEntity.ok(states);
	}

	@GetMapping("/state/{stateId}")
	public ResponseEntity<StateDto> getStateById(@PathVariable long stateId) {
		StateDto stateDto = stateService.getStateById(stateId);
		return ResponseEntity.ok(stateDto);
	}

	@GetMapping("/country/{countryId}/state")
	public ResponseEntity<List<StateDto>> getStateByCountryId(@PathVariable long countryId) {
		List<StateDto> states = stateService.getStateByCountryId(countryId);
		return ResponseEntity.ok(states);
	}

	@PostMapping("/country/{countryId}/state")
	public ResponseEntity<StateDto> addState(@PathVariable long countryId,@RequestBody StateDto stateDto) {
		StateDto createdState = stateService.addState(countryId,stateDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdState);
	}

	@PutMapping("/state/{stateId}")
	public ResponseEntity<StateDto> updateState(@PathVariable long stateId, @RequestBody StateDto stateDto) {
		StateDto updatedState = stateService.updateState(stateId, stateDto);
		return ResponseEntity.ok(updatedState);
	}

	@DeleteMapping("/state/{stateId}")
	public ResponseEntity<ApiResponse> deleteState(@PathVariable long stateId) {
		stateService.deleteState(stateId);
		return ResponseEntity.ok(new ApiResponse(200, "Success", "State deleted Successfully"));
	}
}
