package com.uxeron.psp.Validators;

import java.util.*;

public class EmailValidator implements Validator {

	// Possible ValidationError errors:
	// MissingAt - the given email is missing the @ symbol
	// InvalidSymbols - the given email contains invalid symbols
	// InvalidDomain - the given email's domain is invalid
	public static Collection<ValidationError> validate(String data) {

		ArrayList<ValidationError> list = new ArrayList<>();

		if (EmailContainsAt(data)) {
			if (!EmailContainsDot(data))
				list.add(new ValidationError("InvalidDomain"));
		} else
			list.add(new ValidationError("MissingAt"));

		if (!EmailContainsInvalidSymbols(data)) {
			list.add(new ValidationError("InvalidSymbols"));
		}

		return list;
	}

	public static boolean EmailContainsAt(String email) {
		if (email.contains("@"))
			return true;
		return false;
	}

	public static boolean EmailContainsDot(String email) {
		if (email.substring(email.indexOf("@")).contains("."))
			return true;
		return false;
	}

	public static boolean EmailContainsInvalidSymbols(String email) {
		if (email.contains(" ") || email.substring(email.indexOf("@") + 1).contains("@"))
			return false;
		return true;
	}
}
