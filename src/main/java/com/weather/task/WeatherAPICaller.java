package com.weather.task;

import java.util.Arrays;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.weather.api.response.model.OpenWeatherResponse;
import com.weather.api.util.ApiResponseUtil;
import com.weather.models.CityWeatherDetails;
import com.weather.service.CitiesWeatherServiceImpl;

public class WeatherAPICaller implements Callable<CityWeatherDetails> {
	
	private final static Logger log = Logger.getLogger(WeatherAPICaller.class);

	private RestTemplate restTemplate;

	private String uri;

	public WeatherAPICaller(RestTemplate restTemplate, String uri) {
		this.restTemplate = restTemplate;
		this.uri = uri;
	}

	@Override
	public CityWeatherDetails call() throws Exception {
		OpenWeatherResponse resp = callWeatherAPI();
		return ApiResponseUtil.prepareObject(resp);
	}

	private OpenWeatherResponse callWeatherAPI() {
		
		if(log.isDebugEnabled()){
			log.debug("calling openweather API for >>" + uri);
		} 
		
		ResponseEntity<OpenWeatherResponse> openWeatherAPIResponse = restTemplate.exchange(uri, HttpMethod.GET,	prepareOpenAPIRequest(), OpenWeatherResponse.class);

		if (openWeatherAPIResponse.getBody() != null) {			
			if(log.isDebugEnabled()){
				log.debug("we have openweather API response >>" + openWeatherAPIResponse.getBody());
			} 			
		}
		return openWeatherAPIResponse.getBody();
	}

	private HttpEntity<String> prepareOpenAPIRequest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		return entity;
	}
}