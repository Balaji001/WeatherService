package com.interview.weather.utils;



public class WeatherUtil {

	   public static double convertTemp(Double temp,char measurement) {

	        // converting to Celsius
	        if (measurement == 'C')
	        	temp -= 273;

	        // converting to Farenheit
	        if (measurement == 'F') {
	        	temp = 1.8 * (temp - 273) + 32;
	        }

	        return temp;
	    }
	
	   public static String getAMPM(int indicator) {

	       return (indicator ==0)?"AM":"PM";
	    }
	
	
}
