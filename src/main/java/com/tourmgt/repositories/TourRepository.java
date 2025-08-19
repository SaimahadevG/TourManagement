package com.tourmgt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourmgt.entities.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {
	List<Tour> findByLocation(String var1);
}
