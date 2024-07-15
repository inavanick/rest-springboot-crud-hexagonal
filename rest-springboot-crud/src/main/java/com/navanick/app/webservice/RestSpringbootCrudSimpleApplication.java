package com.navanick.app.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.navanick.lib.people.PeopleRepository;

@SpringBootApplication
class RestSpringbootCrudSimpleApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestSpringbootCrudSimpleApplication.class, args);
	}

	@Bean
	PeopleRepository peopleRepository() {
		return PeopleRepository.creaPeopleRepository();
	}
}
