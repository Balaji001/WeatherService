package com.interview.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.interview.weather.*")
public class WeatherApplication extends SpringBootServletInitializer{
	
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(WeatherApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class);
	}
	
}
