package com.interview.weather.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.interview.weather.bo.TemperatureBO;
import com.interview.weather.bo.WeatherAPIRespBO;
import com.interview.weather.bo.WeatherBO;
import com.interview.weather.controller.WeatherController;
import com.interview.weather.dto.Temperature;
import com.interview.weather.dto.WeatherDTO;
import com.interview.weather.utils.HttpUtils;
import com.interview.weather.utils.WeatherUtil;

@Service
public class WeatherServiceImpl implements WeatherService{

	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${weather.api.url}") 
    private String WEATHER_API_URL;
	@Value("${weather.api_key}") 
    private String WEATHER_API_KEY;
	
	private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

	
	public List<WeatherDTO> getWeatherDetails(String zipCode) {
		// TODO Auto-generated method stub
		String forecast_weather_url = WEATHER_API_URL+"?zip="+zipCode+",us&appid="+WEATHER_API_KEY+"";
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        formatter.setTimeZone(TimeZone.getTimeZone("PST"));
		List<WeatherDTO> list = new ArrayList<WeatherDTO>();

        try {
        	// To limit the connections we can store the response in databse by zipcode reference and 
        	// pre check date base for sub sequent calls.
			JSONObject apiResp = HttpUtils.getConnetion(forecast_weather_url);
			
			
			System.out.println(apiResp);
			JSONArray arr = apiResp.getJSONArray("list");
			for(int i=0;i<24;i++){ //based on the client selection we can change the value
				WeatherDTO weatherDTO = new WeatherDTO();
				JSONObject obj = arr.getJSONObject(i);
				JSONObject mainObject = obj.getJSONObject("main");
				String date_txt = obj.getString("dt_txt");
		        Date date = formatter.parse(date_txt);
		        Calendar cal = new GregorianCalendar();
		        cal.setTime(date);
				System.out.println(date);
				
				Double minTemp = mainObject.getDouble("temp_min");
				Double maxTemp = mainObject.getDouble("temp_max");
				
				Temperature temperatureF = new Temperature();
				temperatureF.setMaxValue(WeatherUtil.convertTemp(maxTemp,'F'));
				temperatureF.setMinValue(WeatherUtil.convertTemp(minTemp,'F'));
				temperatureF.setScales('F');
				
				Temperature temperatureC = new Temperature();
				temperatureC.setMaxValue(WeatherUtil.convertTemp(maxTemp,'C'));
				temperatureC.setMinValue(WeatherUtil.convertTemp(minTemp,'C'));
				temperatureC.setScales('C');
				
				weatherDTO.setTemperatureC(temperatureC);
				weatherDTO.setTemperatureF(temperatureF);
				
				weatherDTO.setTime(cal.get(Calendar.HOUR)+" "+WeatherUtil.getAMPM(cal.get(Calendar.AM_PM)));
				
				
				list.add(weatherDTO);
				
			}			
		} catch (Exception e) {
			logger.error("Erro on Weather service implemetation ",e);
		}
		return list;
	}


	public List<WeatherDTO> getWeatherDetails1(String zipCode) {
		// TODO Auto-generated method stub
		String forecast_weather_url = WEATHER_API_URL+"?zip="+zipCode+",us&appid="+WEATHER_API_KEY+"";
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        formatter.setTimeZone(TimeZone.getTimeZone("PST"));
		List<WeatherDTO> list = new ArrayList<WeatherDTO>();

        try {
        	// To limit the connections we can store the response in databse by zipcode reference and 
        	// pre check date base for sub sequent calls.
			WeatherAPIRespBO apiResp = restTemplate.getForObject(forecast_weather_url, WeatherAPIRespBO.class);
			
			
			List<WeatherBO> arr = apiResp.getWeatherList();
			for(int i=0;i<24;i++){ //based on the client selection we can change the value
				WeatherDTO weatherDTO = new WeatherDTO();
				WeatherBO weatherBO = arr.get(i);
				String date_txt = weatherBO.getDt_txt();
		        Date date = formatter.parse(date_txt);
		        Calendar cal = new GregorianCalendar();
		        cal.setTime(date);
				
				TemperatureBO temp = weatherBO.getMain();
				
				Double minTemp = temp.getTemp_min();
				Double maxTemp = temp.getTemp_max();
				
				Temperature temperatureF = new Temperature();
				temperatureF.setMaxValue(WeatherUtil.convertTemp(maxTemp,'F'));
				temperatureF.setMinValue(WeatherUtil.convertTemp(minTemp,'F'));
				temperatureF.setScales('F');
				
				Temperature temperatureC = new Temperature();
				temperatureC.setMaxValue(WeatherUtil.convertTemp(maxTemp,'C'));
				temperatureC.setMinValue(WeatherUtil.convertTemp(minTemp,'C'));
				temperatureC.setScales('C');
				
				weatherDTO.setTemperatureC(temperatureC);
				weatherDTO.setTemperatureF(temperatureF);
				
				weatherDTO.setTime(cal.get(Calendar.HOUR)+" "+WeatherUtil.getAMPM(cal.get(Calendar.AM_PM)));
				
				
				list.add(weatherDTO);
				
			}			
		} catch (Exception e) {
			logger.error("Erro on Weather service implemetation ",e);
		}
		return list;
	}
	
}
