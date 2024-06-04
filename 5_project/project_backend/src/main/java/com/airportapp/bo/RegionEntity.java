package com.airportapp.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "regions")
public class RegionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "continent")
	private String continent;

	@Column(name = "iso_country")
	private String isoCountry;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContinent() {
		return continent;
	}

	public String getCode() {
		return code;
	}

	public String getIsoCountry() {
		return isoCountry;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}

}
