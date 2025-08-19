package com.tourmgt.responsedtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourResponseDto {
	private Long id;
	private String imageUrl;
	private String discountInPercentage;
	private String title;
	private String description;
	private String duration;
	private String actualPrice;
	private String discountedPrice;
	private String location;
}
