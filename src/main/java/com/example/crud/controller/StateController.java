package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud.dto.StateDto;
import com.example.crud.service.StateService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping
	public ResponseEntity<List<StateDto>> getAllStates() {
		List<StateDto> states = stateService.getAllState();
		return ResponseEntity.ok(states);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StateDto> getStateById(@PathVariable Long id) {
		StateDto stateDto = stateService.getStateById(id);
		return ResponseEntity.ok(stateDto);
	}

	@PostMapping
	public ResponseEntity<StateDto> createState(@RequestBody StateDto StateDto) {
		StateDto createdState = stateService.addState(StateDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdState);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StateDto> updateState(@PathVariable Long id, @RequestBody StateDto StateDto) {

		StateDto updatedState = stateService.updateState(id, StateDto);
		return ResponseEntity.ok(updatedState);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteState(@PathVariable Long id) {

		stateService.deleteState(id);
		return ResponseEntity.noContent().build();

	}
}
