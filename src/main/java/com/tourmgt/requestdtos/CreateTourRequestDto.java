package com.tourmgt.requestdtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTourRequestDto {
	@NotBlank(message = "image url must not be empty")
	private @NotBlank(message = "image url must not be empty") String image;

	@NotBlank(message = "discount must not be empty")
	private @NotBlank(message = "discount must not be empty") String discountInPercentage;

	@NotBlank(message = "title must not be empty")
	private @NotBlank(message = "title must not be empty") String title;

	@NotBlank(message = "descritpion must not be empty")
	private @NotBlank(message = "descritpion must not be empty") String description;

	@NotBlank(message = "duration must not be empty")
	private @NotBlank(message = "duration must not be empty") String duration;

	@NotBlank(message = "actual price must not be empty")
	private @NotBlank(message = "actual price must not be empty") String actualPrice;

	@NotBlank(message = "discounted price must not be empty")
	private @NotBlank(message = "discounted price must not be empty") String discountedPrice;

	@NotBlank(message = "location must not be empty")
	private @NotBlank(message = "location must not be empty") String location;
}
