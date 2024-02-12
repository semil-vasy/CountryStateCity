package com.example.crud.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.crud.dto.CityDto;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.City;
import com.example.crud.repository.CityRepository;
import com.example.crud.service.CityService;

public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CityDto> getAllCity() {
		List<City> cities = cityRepository.findAll();
		return cities.stream().map(this::cityToDto).toList();
	}

	@Override
	public List<CityDto> getCityeByStateId(long stateId) {
		List<City> cities = cityRepository.findByStateId(stateId);
		return cities.stream().map(this::cityToDto).toList();
	}

	@Override
	public CityDto getCityById(long cityId) {
		City city = cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No id found :" + cityId));
		return this.cityToDto(city);
	}

	@Override
	public CityDto addCity(CityDto cityDto) {
		City city = cityRepository.save(this.dtoToCity(cityDto));
		return this.cityToDto(city);
	}

	@Override
	public void deleteCity(long cityId) {
		cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException(404, "No id found :" + cityId));
		cityRepository.deleteById(cityId);
	}

	@Override
	public CityDto updateCity(long cityId, CityDto cityDto) {
		City city = cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException(404, "No id found :" + cityId));

		city.setCityName(cityDto.getCityName());

		City newCity = cityRepository.save(city);
		return this.cityToDto(newCity);
	}

	City dtoToCity(CityDto cityDto) {
		return this.modelMapper.map(cityDto, City.class);
	}

	CityDto cityToDto(City city) {
		return this.modelMapper.map(city, CityDto.class);
	}

}
