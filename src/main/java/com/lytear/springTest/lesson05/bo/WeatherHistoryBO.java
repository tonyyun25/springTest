package com.lytear.springTest.lesson05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.lesson05.dao.WeatherHistoryDAO;
import com.lytear.springTest.lesson05.model.Weather;

@Service
public class WeatherHistoryBO {

	
		@Autowired
		private WeatherHistoryDAO weatherHistoryDAO;
	
		public List<Weather> getWeatherHistory() {
			
			return weatherHistoryDAO.selectWeatherHistory();
		}
		
		public int addWeatherHistory(
				String date
				, String weather
				, double temperatures
				,double precipitation
				, String microDust
				, double windSpeed) {
			return weatherHistoryDAO.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
			
		}
		
}
