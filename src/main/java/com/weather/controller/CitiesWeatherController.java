package com.weather.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.weather.models.CityWeatherDetails;
import com.weather.service.CitiesWeatherService;



@RestController
@RequestMapping(value="/checkWeather")  
public class CitiesWeatherController {
	
	@Autowired
	private CitiesWeatherService citiesWeatherService;

	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON,value="/check")
	public @ResponseBody ResponseEntity<?> checkWeatherDetails(@RequestBody List<String> cities){
		
		if(cities.isEmpty()){
			return new ResponseEntity<>("City not provided", HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<List<CityWeatherDetails>>(citiesWeatherService.getWeatherDetails(cities), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON ,value="/getWeather")
	public @ResponseBody ResponseEntity<?> getWeatherDetails(@RequestParam List<String> cities){
		
		if(cities.isEmpty()){
			return new ResponseEntity<>("City not provided", HttpStatus.BAD_REQUEST); 
		}			
		return new ResponseEntity<List<CityWeatherDetails>>(citiesWeatherService.getWeatherDetails(cities), HttpStatus.OK);
	}
	
	
	
}