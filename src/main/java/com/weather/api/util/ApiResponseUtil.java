package com.weather.api.util;

import java.util.HashMap;
import java.util.Map;

import com.weather.api.response.model.OpenWeatherResponse;
import com.weather.api.response.model.Weather;
import com.weather.models.CityWeatherDetails;
import com.weather.models.DayWeather;

public class ApiResponseUtil {
	
	
	public static CityWeatherDetails prepareObject(OpenWeatherResponse resp){
		CityWeatherDetails det = new CityWeatherDetails();		
		det.setCity(resp.getCity());		
		det.setDayWeatherMap(calculateDayWeather(resp));		
		return det;
	}
		
	private static Map<String,DayWeather> calculateDayWeather(OpenWeatherResponse resp){	
		Map<String,DayWeather> dayTempMap = new HashMap<>();		
		
		for(Weather day : resp.getList()){
			boolean isChanged =  false;
			String dateStr=null;
			
			if(day.getDt_txt() != null && day.getDt_txt().split(" ") != null){
				dateStr = day.getDt_txt().split(" ")[0];
			}		
			
			if(dateStr != null){
				DayWeather dayWeather = dayTempMap.get(dateStr);
				
				if(dayWeather == null){
					dayWeather = new DayWeather(day.getMain().getTemp_min(),day.getMain().getTemp_min());
					isChanged =  true;				
				}else{
					if(day.getMain().getTemp_max() > dayWeather.getMaxTemp()){
						dayWeather.setMaxTemp(day.getMain().getTemp_max());
						isChanged =  true;
					}
					if(day.getMain().getTemp_min() < dayWeather.getMinTemp()){
						dayWeather.setMinTemp(day.getMain().getTemp_min());
						isChanged =  true;
					}				
				}
				
				if(isChanged){
					dayTempMap.put(dateStr, dayWeather);
				}
			}						
		}		
		return dayTempMap;		
	}

}
