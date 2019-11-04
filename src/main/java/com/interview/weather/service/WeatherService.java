package com.interview.weather.service;

import java.util.List;

import com.interview.weather.dto.WeatherDTO;

public interface WeatherService {

	public List<WeatherDTO> getWeatherDetails(String zipCode); //we can define custom exceptiion
	public List<WeatherDTO> getWeatherDetails1(String zipCode);
	
}
