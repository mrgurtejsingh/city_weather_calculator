package com.weather.api.response.model;

import java.io.Serializable;
import java.util.List;

public class OpenWeatherResponse implements Serializable{
	
	private City city;
	
	private List<Weather> list;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Weather> getList() {
		return list;
	}

	public void setList(List<Weather> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "OpenWeatherResponse [city=" + city + ", list=" + list + "]";
	}

	

}
