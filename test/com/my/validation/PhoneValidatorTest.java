package com.my.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PhoneValidatorTest {

	PhoneValidator phoneValidator = new PhoneValidator();

	@Test
	void checkPhoneNumberTestSuccess() {
		assertTrue(phoneValidator.checkPhoneNumber("+37062847379"));
	}

	@Test
	void checkPhoneNumberTestFail() {
		assertFalse(phoneValidator.checkPhoneNumber("+3706284737R"));
	}

	// tikrina, kai reikia pakeisti is 8 i +370
	@Test
	void checkFirstNumberWithChangeTest() {
		assertEquals("+37062847379", phoneValidator.checkFirstNumber("862847379"));
	}

	// tikrina, kai nereikia pakeisti is 8 i +370
	@Test
	void checkFirstNumberWithoutChangeTest() {
		assertEquals("+37062847379", phoneValidator.checkFirstNumber("+37062847379"));
	}
}
