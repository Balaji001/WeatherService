package com.interview.weather.service;

import java.util.List;

import com.interview.weather.dto.WeatherDTO;

public interface WeatherService {

	public List<WeatherDTO> getWeatherDetails(String zipCode) throws Exception; //we can define custom exceptiion
	
}
