package com.interview.weather.controller;

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


@RestController
@RequestMapping("/") 
@Api(value="WeatherController", description="ApiOperations pertaining to weather infromation")
public class WeatherController {

	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	
	@ApiOperation(value = "hourely weather information", response = WeatherDTO.class)
	@RequestMapping(value = "/weather", method= RequestMethod.GET)	
	public ResponseEntity<WeatherDTO> getWeatherInfo(HttpServletRequest req,@RequestParam("zipcode")@Valid String zipcode) {		
		logger.info("Entered inside OrderController.getWeatherInfo >> ");
		
		 TimeZone timeZone = RequestContextUtils.getTimeZone(req);
		 
		 WeatherDTO weatherDTO = null;
		
		logger.info("Just before leaving OrderController.getWeatherInfo >> ");
		return new ResponseEntity<WeatherDTO>(weatherDTO, HttpStatus.OK);
	}
	
}