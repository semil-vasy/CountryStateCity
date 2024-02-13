package com.example.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stateId;

	private String stateName;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@JsonIgnore
	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<City> city;
	
}
