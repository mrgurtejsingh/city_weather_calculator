package com.weather.models;

import java.io.Serializable;
import java.util.Map;

import com.weather.api.response.model.City;

public class CityWeatherDetails implements Serializable{
	
	private City city;
	
	private Map<String , DayWeather> dayWeatherMap;
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Map<String, DayWeather> getDayWeatherMap() {
		return dayWeatherMap;
	}

	public void setDayWeatherMap(Map<String, DayWeather> dayWeatherMap) {
		this.dayWeatherMap = dayWeatherMap;
	}
	
	
}
