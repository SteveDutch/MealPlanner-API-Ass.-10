package com.stevedutch.assignment10.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevedutch.assignment10.domain.DayResponse;
import com.stevedutch.assignment10.domain.WeekResponse;
import com.stevedutch.assignment10.service.ApiService;

@RestController
public class WebController {
	@Autowired
	DayResponse day = new DayResponse();
//	@Autowired
	WeekResponse week = new WeekResponse();
	@Autowired
	ApiService apiService = new ApiService();
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<String> getWeekMeals(String numCalories, String diet, 
			String exclusions) {
					Integer maxCal = Integer.valueOf(numCalories);
					String timeFrame = "week";
					ResponseEntity<String> weekMeal = apiService.callApi(maxCal, diet, exclusions, timeFrame);
					return weekMeal;
	}
		

	@GetMapping("mealplanner/day")
	public ResponseEntity<String> getDayMeals(String numCalories, String diet, 
			String exclusions) {
					Integer maxCal = Integer.valueOf(numCalories);
					String timeFrame = "day";
					ResponseEntity<String> dayMeal = apiService.callApi(maxCal, diet, exclusions, timeFrame);
					
//					ResponseEntity<DayResponse> dayMeal= day.callApiExample(maxCal, diet, exclusions);
					return dayMeal;
		
	}

}
// TODO rt.getBod()
// to get json file 
// private Strings for vorlommende Variablen
// put in DTO or POJO (und callAPiExample in POJO-Service)
// weeks mit DateFormat?
// ggf instruchtion GETMAPPING
// watch video 14-09  zu Ende, von 12:03 ab