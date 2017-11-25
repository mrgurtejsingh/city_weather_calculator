package com.weather.api.response.model;

import java.io.Serializable;

public class Temperature implements Serializable {
	
	private String temp;
	
	private String pressure;
	
	private String humidity;
	
	private Double temp_min;
	
	private Double temp_max;

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public Double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}

	public Double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}

	@Override
	public String toString() {
		return "Temperature [temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min="
				+ temp_min + ", temp_max=" + temp_max + "]";
	}

}