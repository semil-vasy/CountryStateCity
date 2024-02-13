package com.example.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long countryId;

	private String countryName;

	@JsonIgnore
	@OneToMany(mappedBy = "country",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<State> state;

}
