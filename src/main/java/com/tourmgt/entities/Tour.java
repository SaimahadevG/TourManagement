package com.tourmgt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tour")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "image_url", nullable = false)
	private String imageUrl;

	@Column(name = "discount_in_percentage", nullable = false)
	private String discountInPercentage;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(name = "duration", nullable = false)
	private String duration;

	@Column(name = "actual_price", nullable = false)
	private String actualPrice;

	@Column(name = "discounted_price", nullable = false)
	private String discountedPrice;

	@Column(name = "location", nullable = false)
	private String location;

}
