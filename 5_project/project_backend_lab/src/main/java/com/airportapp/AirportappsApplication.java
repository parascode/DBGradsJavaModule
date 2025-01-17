package com.airportapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ComponentScan(basePackages = "com")

public class AirportappsApplication {
	public static void main(String[] args) {
				SpringApplication.run(AirportappsApplication.class, args);
	}

}
