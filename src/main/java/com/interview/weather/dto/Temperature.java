package com.interview.weather.dto;

public class Temperature {
	
	private Double minValue;
	private Double maxValue;

	private Character scales;
	
	public Double getMinValue() {
		return minValue;
	}
	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}
	public Double getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}
	public Character getScales() {
		return scales;
	}
	public void setScales(Character scales) {
		this.scales = scales;
	}
	
	
}
