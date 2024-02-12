package com.example.crud.service;

import java.util.List;

import com.example.crud.dto.StateDto;

public interface StateService {

	List<StateDto> getAllState();

	List<StateDto> getStateByCountryId(long countryId);

	StateDto getStateById(long stateId);

	StateDto addState(StateDto stateDto);

	void deleteState(long stateId);

	StateDto updateState(long stateId, StateDto stateDto);
}
