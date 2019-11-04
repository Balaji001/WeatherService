
package com.interview.weather;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyDouble;












import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.interview.weather.bo.WeatherAPIRespBO;
import com.interview.weather.bo.WeatherBO;
import com.interview.weather.dto.WeatherDTO;
import com.interview.weather.service.WeatherService;
import com.interview.weather.service.WeatherServiceImpl;


/**
 * Class to test functionality of Weather Service class using PowerMockito
 * framework running with JUnit
 * 
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ WeatherService.class })
@PowerMockIgnore("org.slf4j.*")
public class TestWeatherSerice {

    @InjectMocks
    private WeatherServiceImpl weatherService;
   
    @Value("${weather.api.url}") 
    private String WEATHER_API_URL;
	@Value("${weather.api_key}") 
    private String WEATHER_API_KEY;
    
	 @Mock
	 RestTemplate restTemplate;
	 
    /**
     * Initialize all the mocks before executing each test case
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    /**
     * Test findCategorylist method
     */
    
    @Test
    public void testGetWeatherDetails() throws Exception {
    	String zipCode = "85027";
    	
    	String forecast_weather_url = WEATHER_API_URL+"?zip="+zipCode+",us&appid="+WEATHER_API_KEY+"";
		
		WeatherAPIRespBO weatherAPIRespBO = this.getWeatherAPIResponse();
		
		 Mockito
         .when(restTemplate.getForObject(
        		 forecast_weather_url, WeatherAPIRespBO.class))
         .thenReturn(weatherAPIRespBO);

	   List<WeatherDTO> list = weatherService.getWeatherDetails1(zipCode);
	   
       Assert.assertEquals(weatherAPIRespBO.getWeatherList().get(0), list.get(0));
		
    }
    
   
  private static WeatherAPIRespBO getWeatherAPIResponse(){
	  
	  WeatherAPIRespBO weatherAPIRespBO = new WeatherAPIRespBO();
	  
	  List<WeatherBO> arr = new ArrayList<WeatherBO>();
	  
	  weatherAPIRespBO.setCod("200");
	  weatherAPIRespBO.setWeatherList(arr);
	  
	  return weatherAPIRespBO;
  }
    

    
}
