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
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cityId;

	private String cityName;

//	@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

}
