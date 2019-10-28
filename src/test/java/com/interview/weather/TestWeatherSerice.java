package com.interview.weather;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyDouble;





import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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
    	//mock the httputil 
    	//specify criteria when service method calls return init json
    	//call weather service 
    	//do assertUtils
    
    }
    
   
   //initialize the Weather JSON Object returned while calling httpUtil

    
}
