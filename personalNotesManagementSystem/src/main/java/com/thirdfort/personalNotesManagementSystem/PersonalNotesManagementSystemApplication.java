package com.thirdfort.personalNotesManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.thirdfort.personalNotesManagementSystemModels.Model","com.thirdfort.personalNotesManagementSystemModels.ModelDto"})
@SpringBootApplication
public class PersonalNotesManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalNotesManagementSystemApplication.class, args);
	}

}
