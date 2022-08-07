package com.stevedutch.assignment10.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.stevedutch.assignment10.dto.DayResponse;
import com.stevedutch.assignment10.dto.WeekResponse;
import com.stevedutch.assignment10.service.ApiService;

@RestController
public class WebController {
	
	@Autowired
	DayResponse day = new DayResponse();
//	@Autowired
	WeekResponse week = new WeekResponse();
	@Autowired
	ApiService apiService = new ApiService();
	RestTemplate rt = new RestTemplate();
	
	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, 
			String exclusions)/* throws JsonMappingException, JsonProcessingException */ {
		Integer maxCal = Integer.valueOf(numCalories);
		String timeFrame = "day";
		ResponseEntity<DayResponse> response = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame), DayResponse.class);
		System.out.println("\n Hilsen fra mealplnnar/day AND it's shown: ResponseEntity<DayResponse> response " + response);
		
		
//		DayResponse dayPlan = new DayResponse(response.getBody());
//		System.out.println("\n Hilsen fra mealplnnar/day AND it's shown: response.getBody " + response.getBody());
//		System.out.println(" \n Hilsen fra mealplnnar/day AND it's shown: DayResponse dayPlan  " +  dayPlan );
////					ResponseEntity<DayResponse> dayMeal= day.callApiExample(maxCal, diet, exclusions);
//		// try with jackson
//		ObjectMapper objectMapper = new ObjectMapper();
//		ResponseEntity<String> jackTesto = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame), String.class);
//		DayResponse jacktest = objectMapper.readValue(jackTesto.getBody(), DayResponse.class);
//		System.out.println(jacktest);
		return response;
		
	}
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, 
			String exclusions) {
					Integer maxCal = Integer.valueOf(numCalories);
					String timeFrame = "week";
					ResponseEntity<WeekResponse> weekMeal = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame), WeekResponse.class);
					return weekMeal;
	}
		


}
// TODO rt.getBod()
// to get json file 
// private Strings for vorlommende Variablen
// put in DTO or POJO (und callAPiExample in POJO-Service)
// weeks mit DateFormat?
// ggf instruchtion GETMAPPING
// watch video 14-09  zu Ende, von 12:03 ab