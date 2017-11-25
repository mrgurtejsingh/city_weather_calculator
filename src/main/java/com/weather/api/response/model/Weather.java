package com.weather.api.response.model;

import java.io.Serializable;

public class Weather implements Serializable{

	
	private String dt;
	
	private String dt_txt;
	
	private Temperature main;

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	public Temperature getMain() {
		return main;
	}

	public void setMain(Temperature main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "Weather [dt=" + dt + ", dt_txt=" + dt_txt + ", main=" + main + "]";
	}
	
	
}