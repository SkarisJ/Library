package com.validators;

import java.util.Set;

public class PasswordChecker {

	String _specialCharacters;
	int _minLength;

	public PasswordChecker(Set<Character> specialCharacters, Integer minLength) {
		_specialCharacters = specialCharacters.toString();
		_minLength = minLength;
	}

	public Boolean validate(String password) {
		return validateLength(password) && validateUpperCase(password) && validateSpecialSymbols(password);
	}

	private Boolean validateLength(String password) {
		if (password.length() >= _minLength) {
			return true;
		}
		return false;
	}

	private Boolean validateUpperCase(String password) {
		for (char symbol : password.toCharArray()) {
			if (Character.isUpperCase(symbol)) {
				return true;
			}
		}
		return false;
	}

	private boolean validateSpecialSymbols(String password) {
		for (char symbol : password.toCharArray()) {
			if (!Character.isLetterOrDigit(symbol) && _specialCharacters.contains(String.valueOf(symbol))) {
				return true;
			}
		}
		return false;
	}
}
