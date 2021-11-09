package com.my.main.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import com.my.main.models.UserModel;
import com.my.main.repositories.UserRepository;
import com.uxeron.psp.Validators.EmailValidator;
import com.uxeron.psp.Validators.PasswordChecker;
import com.uxeron.psp.Validators.PhoneValidator;
import com.uxeron.psp.Validators.ValidationError;

public class UserService {

	EmailValidator emailValidator;
	PhoneValidator phoneValidator;
	PasswordChecker passwordValidator;
	UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public String createUser(String name, String surname, String phoneNumber, String email, String address,
			String password, String path) throws IOException {

		UserModel user = new UserModel(name, surname, phoneNumber, email, address, password);
		Collection<ValidationError> list = new ArrayList<>();

		list = userValidation(phoneNumber, email, password);

		if (list.isEmpty()) {
			return userRepository.createUser(path, user);

		} else {
			return "Klaidingai ivesti duomenys";
		}
	}

	public String findUserById(int id, String path) throws IOException {

		return userRepository.findUserById(path, id);
	}

	private ArrayList<ValidationError> userValidation(String phoneNumber, String email, String password) {

		ArrayList<ValidationError> list = new ArrayList<>();

		// list.addAll(phoneValidator.validate(phoneNumber)); //not working
		list.addAll(emailValidator.validate(email));
		list.addAll(passwordValidator.validate(password));

		return list;
	}
}
