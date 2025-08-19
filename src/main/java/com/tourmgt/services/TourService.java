package com.tourmgt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourmgt.entities.Tour;
import com.tourmgt.exceptions.TourNotFoundException;
import com.tourmgt.repositories.TourRepository;
import com.tourmgt.requestdtos.CreateTourRequestDto;
import com.tourmgt.responsedtos.TourResponseDto;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TourService {
	private final TourRepository tourRepo;

	@Transactional
	public TourResponseDto createTour(CreateTourRequestDto requestDto) {
		Tour tour = Tour.builder().actualPrice(requestDto.getActualPrice()).description(requestDto.getDescription())
				.discountedPrice(requestDto.getDiscountedPrice())
				.discountInPercentage(requestDto.getDiscountInPercentage()).duration(requestDto.getDuration())
				.imageUrl(requestDto.getImage()).title(requestDto.getTitle())
				.location(requestDto.getLocation().toUpperCase()).build();

		Tour tourFromDb = (Tour) tourRepo.save(tour);

		return TourResponseDto.builder().id(tourFromDb.getId()).actualPrice(tourFromDb.getActualPrice())
				.description(tourFromDb.getDescription()).discountInPercentage(tourFromDb.getDiscountInPercentage())
				.duration(tourFromDb.getDuration()).discountedPrice(tourFromDb.getDiscountedPrice())
				.imageUrl(tourFromDb.getImageUrl()).title(tourFromDb.getTitle())
				.location(requestDto.getLocation().toUpperCase()).build();
	}

	public List<TourResponseDto> getAllTours() {
		List<Tour> allAvailableTours = tourRepo.findAll();
		return allAvailableTours.stream()
				.map(tour -> TourResponseDto.builder().id(tour.getId()).actualPrice(tour.getActualPrice())
						.description(tour.getDescription()).discountedPrice(tour.getDiscountedPrice())
						.discountInPercentage(tour.getDiscountInPercentage()).duration(tour.getDuration())
						.imageUrl(tour.getImageUrl()).title(tour.getTitle()).location(tour.getLocation()).build())
				.toList();
	}

	public TourResponseDto getTourById(Long id) {
		Tour tourFromDb = tourRepo.findById(id)
				.orElseThrow(() -> new TourNotFoundException("cant find tour with given id"));
		return TourResponseDto.builder().id(tourFromDb.getId()).actualPrice(tourFromDb.getActualPrice())
				.description(tourFromDb.getDescription()).discountInPercentage(tourFromDb.getDiscountInPercentage())
				.duration(tourFromDb.getDuration()).discountedPrice(tourFromDb.getDiscountedPrice())
				.imageUrl(tourFromDb.getImageUrl()).title(tourFromDb.getTitle()).location(tourFromDb.getLocation())
				.build();
	}

	public List<TourResponseDto> getToursByLocation(String location) {
		List<Tour> byLocation = tourRepo.findByLocation(location.toUpperCase());
		return byLocation.stream()
				.map(tour -> TourResponseDto.builder().id(tour.getId()).actualPrice(tour.getActualPrice())
						.description(tour.getDescription()).discountedPrice(tour.getDiscountedPrice())
						.discountInPercentage(tour.getDiscountInPercentage()).duration(tour.getDuration())
						.imageUrl(tour.getImageUrl()).title(tour.getTitle()).location(tour.getLocation()).build())
				.toList();
	}
}
