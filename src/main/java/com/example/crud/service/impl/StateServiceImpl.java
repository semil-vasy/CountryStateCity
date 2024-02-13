package com.example.crud.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dto.StateDto;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Country;
import com.example.crud.model.State;
import com.example.crud.repository.CountryRepository;
import com.example.crud.repository.StateRepository;
import com.example.crud.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<StateDto> getAllState() {
		List<State> states = stateRepository.findAll();
		return states.stream().map(this::stateToDto).toList();
	}

	@Override
	public List<StateDto> getStateByCountryId(long countryId) {
		Country country = countryRepository.findById(countryId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No ocuntry id found : " + countryId));
		List<State> states = stateRepository.findByCountry(country);
		return states.stream().map(this::stateToDto).toList();
	}

	@Override
	public StateDto getStateById(long stateId) {
		State state = stateRepository.findById(stateId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No id found : " + stateId));
		return this.stateToDto(state);
	}

	@Override
	public StateDto addState(long countryId, StateDto stateDto) {
		Country country = countryRepository.findById(countryId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No ocuntry id found : " + countryId));
		stateDto.setCountry(country);
		State state = stateRepository.save(this.dtoToState(stateDto));
		return this.stateToDto(state);
	}

	@Override
	public void deleteState(long stateId) {
		stateRepository.findById(stateId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No id found : " + stateId));
		stateRepository.deleteById(stateId);
	}

	@Override
	public StateDto updateState(long stateId, StateDto stateDto) {
		State state = stateRepository.findById(stateId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No id found : " + stateId));

		state.setStateName(stateDto.getStateName());

		State newCountry = stateRepository.save(state);
		return this.stateToDto(newCountry);
	}

	State dtoToState(StateDto stateDto) {
		return this.modelMapper.map(stateDto, State.class);
	}

	StateDto stateToDto(State state) {
		return this.modelMapper.map(state, StateDto.class);
	}

}
