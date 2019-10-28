package com.interview.weather.config;

import java.io.IOException;
import java.util.Properties;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan({ "com.interview.weather.*" })
public class ApplicationConfiguration {   

	    @Bean
	    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }
	    
}
