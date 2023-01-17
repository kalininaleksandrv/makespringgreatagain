package com.github.kalininaleksandrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MakespringgreatagainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakespringgreatagainApplication.class, args);
	}

}

// TODO: 17.12.2022 implement simple Once-Per-Request filter
// TODO: 17.12.2022 example with rest template, webClient and Feign