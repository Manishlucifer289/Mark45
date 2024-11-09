package com.mark45;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Mark45Application {

	public static void main(String[] args) {

		SpringApplication.run(Mark45Application.class, args);
	}
	@Bean
	public ModelMapper getmodelmapper(){

		return new ModelMapper();
	}

}
