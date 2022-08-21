package com.stevedutch.assignment10.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stevedutch.assignment10.dto.DayResponse;
import com.stevedutch.assignment10.dto.WeekResponse;
import com.stevedutch.assignment10.service.ApiService;

@RestController
public class WebController {

	DayResponse day = new DayResponse();
	WeekResponse week = new WeekResponse();
	@Autowired
	ApiService apiService = new ApiService();
	RestTemplate rt = new RestTemplate();

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		String timeFrame = "day";
		if (numCalories == null || diet == null || exclusions == null) {
			ResponseEntity<DayResponse> response = rt.getForEntity(apiService.callDefault(timeFrame), DayResponse.class);
			return response;
		}
		Integer maxCal = Integer.valueOf(numCalories);
		ResponseEntity<DayResponse> response = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame),
				DayResponse.class);
		return response;
	}

	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
		Integer maxCal = Integer.valueOf(numCalories);
		String timeFrame = "week";
		ResponseEntity<WeekResponse> weekMeal = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame),
				WeekResponse.class);
		return weekMeal;
	}

}
