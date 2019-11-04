package com.interview.weather.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ExceptionController {
	
	private static final Logger logger =LoggerFactory.getLogger(ExceptionController.class);
	
 	@ExceptionHandler(Exception.class)
 	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internalstatus error occured")
    public void handleInternalException(HttpServletRequest request, Exception ex) throws Exception{
 		logger.error("error occured due to",ex);
    }
    
 
}
