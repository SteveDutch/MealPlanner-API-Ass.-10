package com.stevedutch.assignment10.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WeekResponseTest {

	@Test
	void test() {
		DayResponse sut = new DayResponse();
		sut.callApiExample(1500, "paleo", "gluten");
		System.out.println(sut);
	}

}
