package com.lytear.springTest.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lytear.springTest.lesson05.bo.WeatherHistoryBO;
import com.lytear.springTest.lesson05.model.Weather;
/*
 * 1. javax.el.PropertyNotFoundException: Property [temperatures] not found on type
 *  [java.lang.String]
 *  : forEach 문 El tag를 items="weatherHistory"로 잘못 입력
 * 2. 모델 값을 못 읽어옴 
 *  : model.addAttribute 빠짐
 * 
 * */


@RequestMapping("/lesson05/test05")
@Controller
public class WeatherHistoryController {

	
	// 종합문제
		/* 5. 구글링 기상청 날씨
		 * 날씨에 해당하는 이미지로 교체. 비가 텍스트인데 이미지로 교체
		 * 링크 말고 이미지 다운 받아 사용해
		 * 왼쪽 내비, 섹션, 푸터 (헤더 X). 
		 * 
		 * 6. spring redirect 방법 찾아서 해
		 * 
		 * */
	
	/* webINF는 외부에서 접근 불가능하므로 webapp 아래 (이것도 정석은 아님)
	 * */
		
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/weather_history")
	public String weatherHistory(Model model) {
		
		List<Weather> weatherHistory = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherHistory",weatherHistory);
		
		return "lesson05/weatherhistory";
	}
	
	  
	@GetMapping("/add_weather_view")
	public String addWeatherView() {
		return "lesson05/weatherRecord";
	}
	@PostMapping("/add_weather")
	public String addWeather(
			@RequestParam("date") String date
			,@RequestParam("weather") String weather
			,@RequestParam("temperatures") double temperatures
			,@RequestParam("precipitation") double precipitation
			,@RequestParam("microDust") String microDust
			,@RequestParam("windSpeed") double windSpeed
			
			
			) {
			
		weatherHistoryBO.addWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		return "redirect:/lesson05/test05/weather_history";
	}
	
	
	
	
}
