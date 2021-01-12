package com.thirdfoot.personalNotesManagementSystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages = {"com.thirdfoot.personalNotesManagementSystemModels"})
@ComponentScan(basePackages = {"com.thirdfoot.personalNotesManagementSystem.controller","com.thirdfoot.personalNotesManagementSystem.repository","com.thirdfoot.personalNotesManagementSystem.service"})
@SpringBootApplication
public class PersonalNotesManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalNotesManagementSystemApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
