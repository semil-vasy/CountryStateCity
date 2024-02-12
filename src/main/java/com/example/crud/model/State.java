package com.example.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stateId;

	private String stateName;
	
//	@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
}
