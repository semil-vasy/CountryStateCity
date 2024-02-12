package com.example.crud.service;

import java.util.List;

import com.example.crud.dto.CityDto;

public interface CityService {
	List<CityDto> getAllCity();

	List<CityDto> getCityeByStateId(long stateId);

	CityDto getCityById(long cityId);

	CityDto addCity(CityDto cityDto);

	void deleteCity(long cityId);

	CityDto updateCity(long cityId, CityDto cityDto);
}
