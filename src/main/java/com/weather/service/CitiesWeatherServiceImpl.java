package com.weather.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.client.RestTemplate;

import com.weather.models.CityWeatherDetails;

import com.weather.task.WeatherAPICaller;

public class CitiesWeatherServiceImpl implements CitiesWeatherService {
	
	private final static Logger log = Logger.getLogger(CitiesWeatherServiceImpl.class); 

	private static final ExecutorService mainExecutor = Executors.newFixedThreadPool(10);

	@Autowired
	private RestTemplate restTemplate;

	final String uri = "http://api.openweathermap.org/data/2.5/forecast?appid=f125f7948ba90c56528b70ce39860d7f&q=";

	@Override
	public List<CityWeatherDetails> getWeatherDetails(List<String> cities) {
		List<CityWeatherDetails> cityWeatherDetails = new ArrayList<>();

		List<Future<CityWeatherDetails>> futures = new ArrayList<>();

		for (String currentCity : cities) {			
			futures.add(mainExecutor.submit(new WeatherAPICaller(restTemplate, uri + currentCity)));
		}

		for (Future<CityWeatherDetails> futureTask : futures) {	
			try {
				while (!futureTask.isDone()) {					
					Thread.sleep(1); 
				}			
				cityWeatherDetails.add(futureTask.get());
			} catch (InterruptedException | ExecutionException e) {				
				e.printStackTrace();
			}
		}
		return cityWeatherDetails;
	}
}