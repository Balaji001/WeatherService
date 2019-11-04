package com.interview.weather.controller;

import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.interview.weather.dto.WeatherDTO;
import com.interview.weather.service.WeatherService;


@RestController
@RequestMapping("/") 
@Api(value="WeatherController", description="ApiOperations pertaining to weather infromation")
public class WeatherController {

	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	 /**
     * Weather service
     * <p>
     * This end point will return weather details on hourly basis
     * <p>
     * 
     * @return list 
     *        It will return list of Weather DTO  which contains min.max temperature and hour.                    
     *           
     */
	
	@ApiOperation(value = "hourely weather information", response = WeatherDTO.class)
	@RequestMapping(value = "/weather", method= RequestMethod.GET)	
	public ResponseEntity<List<WeatherDTO>> getWeatherInfo(HttpServletRequest req,@RequestParam("zipcode")@Valid String zipcode) {		
		logger.info("Entered inside OrderController.getWeatherInfo >> ");
		
		 TimeZone timeZone = RequestContextUtils.getTimeZone(req);
		 
		 List<WeatherDTO> weatherDTO = weatherService.getWeatherDetails1(zipcode);
		
		logger.info("Just before leaving OrderController.getWeatherInfo >> ");
		return new ResponseEntity<List<WeatherDTO>>(weatherDTO, HttpStatus.OK);
	}
	
}