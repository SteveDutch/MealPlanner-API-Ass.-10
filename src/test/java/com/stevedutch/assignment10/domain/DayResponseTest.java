package com.stevedutch.assignment10.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayResponseTest {

	@Test
	void test() {
		DayResponse sut = new DayResponse();
		sut.callApiExample(1500, "paleo", "gluten");
	}

}
