package com.iscte.engsoft.grupob.calendarapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalendarApplicationTest {


	@Test
	void contextLoads() {
	}

	@Test
	void applicationStartsSuccessfully() {
		assertDoesNotThrow(() -> CalendarApplication.main(new String[]{""}));
	}
}
