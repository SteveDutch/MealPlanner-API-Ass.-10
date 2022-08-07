package com.stevedutch.assignment10.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.stevedutch.assignment10.service.ApiService;

class DayResponseTest {

	@Test
	void test() {
		ApiService apiService = new ApiService();
		System.out.println(apiService.getKeyValue());
//		DayResponse sut = new DayResponse(null, null, null, null, null, null);
		apiService.callApi(1500, "paleo", "gluten", "day");

	}

}
