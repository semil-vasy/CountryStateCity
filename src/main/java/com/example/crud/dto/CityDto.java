package com.example.crud.dto;

import com.example.crud.model.State;

import lombok.Data;

@Data
public class CityDto {
	
	private long cityId;

	private String cityName;

	private State state;
	
}
