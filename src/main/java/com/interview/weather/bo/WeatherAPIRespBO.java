package com.interview.weather.bo;

import java.util.List;

public class WeatherAPIRespBO {

		private Integer cnt;
		private String cod;
		private Double message;
		private List<WeatherBO> weatherList;
		public Integer getCnt() {
			return cnt;
		}
		public void setCnt(Integer cnt) {
			this.cnt = cnt;
		}
		public String getCod() {
			return cod;
		}
		public void setCod(String cod) {
			this.cod = cod;
		}
		public Double getMessage() {
			return message;
		}
		public void setMessage(Double message) {
			this.message = message;
		}
		public List<WeatherBO> getWeatherList() {
			return weatherList;
		}
		public void setWeatherList(List<WeatherBO> weatherList) {
			this.weatherList = weatherList;
		}
		
		
		
		
		
}
