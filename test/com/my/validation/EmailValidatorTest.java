package com.my.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailValidatorTest {

	EmailValidator emailValidator = new EmailValidator();

	@Test
	void checkEmailSymbolTestSuccess() {
		assertTrue(emailValidator.checkEmailSymbol("test@gmail.com"));
	}

	@Test
	void checkEmailSymbolTestFail() {
		assertFalse(emailValidator.checkEmailSymbol("testgmail.com"));
	}

	@Test
	void checkEmailTestSuccess() {
		assertTrue(emailValidator.checkEmail("test@gmail.com"));
	}

	@Test
	void checkEmailTestFail() {
		assertFalse(emailValidator.checkEmail("¶test£@gmail.com"));
	}

	@Test
	void checkEmailDomainSuccess() {
		assertTrue(emailValidator.checkDomainAndTLD("test@gmail.com"));
	}

	@Test
	void checkEmailDomainFail() {
		assertFalse(emailValidator.checkDomainAndTLD("test@"));
	}
}
