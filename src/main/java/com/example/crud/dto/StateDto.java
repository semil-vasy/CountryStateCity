package com.example.crud.dto;

import com.example.crud.model.Country;

import lombok.Data;

@Data
public class StateDto {

	private long stateId;

	private String stateName;

	private Country country;

}
