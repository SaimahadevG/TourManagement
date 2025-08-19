package com.tourmgt.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourmgt.requestdtos.CreateTourRequestDto;
import com.tourmgt.responsedtos.TourResponseDto;
import com.tourmgt.services.TourService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tours")
@Validated
@AllArgsConstructor
public class TourController {
	private final TourService tourService;

	@GetMapping
	public ResponseEntity<List<TourResponseDto>> getAllTours() {
		List allTours = this.tourService.getAllTours();
		return ResponseEntity.ok(allTours);
	}

	@GetMapping(value = { "/{id}" })
	public ResponseEntity<TourResponseDto> getTourById(
			@PathVariable @NotNull(message = "id cant be null") @NotNull(message = "id cant be null") Long id) {
		TourResponseDto tourById = this.tourService.getTourById(id);
		return ResponseEntity.ok(tourById);
	}

	@GetMapping(value = { "/location" })
	public ResponseEntity<List<TourResponseDto>> getTourByLocation(
			@RequestParam @NotBlank(message = "place cant be null") @NotBlank(message = "place cant be null") String place) {
		List toursByLocation = this.tourService.getToursByLocation(place);
		return ResponseEntity.ok(toursByLocation);
	}

	@PostMapping
	public ResponseEntity<TourResponseDto> createTour(@RequestBody @Validated CreateTourRequestDto requestDto) {
		TourResponseDto createdTour = this.tourService.createTour(requestDto);
		return ResponseEntity.ok(createdTour);
	}
}
