package com.flixflip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlixflipApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlixflipApplication.class, args);
	}
}
