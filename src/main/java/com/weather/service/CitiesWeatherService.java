package com.weather.service;

import java.util.List;


import com.weather.models.CityWeatherDetails;

public interface CitiesWeatherService {

	public List<CityWeatherDetails> getWeatherDetails(List<String> cities);
	
	
	
}
