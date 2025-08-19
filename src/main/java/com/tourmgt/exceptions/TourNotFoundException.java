package com.tourmgt.exceptions;

public class TourNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TourNotFoundException(String message) {
		super(message);
	}
}
