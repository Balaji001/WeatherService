package com.interview.weather.dto;

public class WeatherDTO {
	private String time;
	private Temperature temperatureC;
	private Temperature temperatureF;

	public String getTime() {
		return time;
	}

	public void setTime(String i) {
		this.time = i;
	}

	public Temperature getTemperatureC() {
		return temperatureC;
	}

	public void setTemperatureC(Temperature temperatureC) {
		this.temperatureC = temperatureC;
	}

	public Temperature getTemperatureF() {
		return temperatureF;
	}

	public void setTemperatureF(Temperature temperatureF) {
		this.temperatureF = temperatureF;
	}

	

	

	
	
	
}
