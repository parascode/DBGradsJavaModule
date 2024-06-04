package com.airportapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airportapp.bo.NavAidEntity;

public interface INavAidRepository extends JpaRepository<NavAidEntity, Long> {

	List<NavAidEntity> findNavAidsByLatitude(double code);

	List<NavAidEntity> findNavAidsByLongitude(double continent);

	List<NavAidEntity> findNavAidsByName(String country);
}
