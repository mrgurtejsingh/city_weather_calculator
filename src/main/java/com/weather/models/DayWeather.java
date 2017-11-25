package com.weather.models;

import java.io.Serializable;

public class DayWeather implements Serializable{
		
	private Double minTemp;
	
	private Double maxTemp;
	
	public DayWeather(Double minTemp, Double maxTemp) {
		super();
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public Double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}

	public Double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}
	

}