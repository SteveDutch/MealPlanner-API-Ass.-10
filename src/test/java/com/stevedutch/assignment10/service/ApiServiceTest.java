package com.stevedutch.assignment10.service;

import org.junit.jupiter.api.Test;

class ApiServiceTest {

	@Test
	void test_does_it_get_TheAPI_Key() {
		ApiService sut = new ApiService();
		String exspectedResult = sut.getKeyValue();
		System.out.println(exspectedResult);
	}
	
	@Test
	void test() {
		ApiService sut = new ApiService();
		sut.callApi(1500, "paleo", "gluten", "day");
		System.out.println(sut);
	}

}
