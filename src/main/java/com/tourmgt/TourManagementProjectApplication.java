package com.tourmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TourManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourManagementProjectApplication.class, args);
	}

}
