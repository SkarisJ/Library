package com.my.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordCheckerTest {

	PasswordChecker passwordChecker = new PasswordChecker();

	@Test
	void checkLengthTestSuccess() {
		assertTrue(passwordChecker.checkLength("Asdef112"));
	}

	@Test
	void checkLengthTestFail() {
		assertFalse(passwordChecker.checkLength("Asd112"));
	}

	@Test
	void checkUpperCaseTestSuccess() {
		assertTrue(passwordChecker.checkUpperCase("Asdef112"));
	}

	@Test
	void checkUpperCaseTestFail() {
		assertFalse(passwordChecker.checkLength("asdef112"));
	}

	@Test
	void checkSpecialSymbolTestSuccess() {
		assertTrue(passwordChecker.checkSpecialSymbol("Asdef112@"));
	}

	@Test
	void checkSpecialSymbolTestFail() {
		assertFalse(passwordChecker.checkUpperCase("Asdef112"));
	}
}
