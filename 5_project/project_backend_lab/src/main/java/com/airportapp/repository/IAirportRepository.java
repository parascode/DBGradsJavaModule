package com.airportapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airportapp.bo.AirportEntity;

public interface IAirportRepository extends JpaRepository<AirportEntity, Long> {

	List<AirportEntity> findAirportsByType(String type);

	//todo --> declare method find Airports by name
	
	//todo --> declare method find Airports by latitude
	

	//todo --> declare method find Airports by longitude
	
	

}
