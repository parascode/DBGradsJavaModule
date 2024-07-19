package com.airportapp.webservices;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airportapp.functions.TransformerFunctions;
import com.airportapp.repository.IAirportRepository;

@RestController
public class AirportRestController {
	private Logger logger = LoggerFactory.getLogger(AirportRestController.class);

	
	//todo
	//Add IAirportService dependency

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(path = "/airports/bytype/{type}")
	public  AirportsReponse findAirportsByType(@PathVariable("type") String type) {
	//todo
	//Invoke appropriate methods on IAirportService
	
	}
}
