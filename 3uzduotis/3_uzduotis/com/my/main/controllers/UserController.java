package com.my.main.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.my.main.repositories.UserRepository;
import com.my.main.services.UserService;

public class UserController {

	UserService userService;
	UserRepository user;

	public UserController() {

		userService = new UserService();
		user = new UserRepository();
	}

	public void start() throws IOException {
		int choice;
		int confirm;
		String name;
		String surname;
		String phoneNumber;
		String email;
		String address;
		String password;
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Irasykite norima eilutes numeri");
		System.out.println("1. Sukurti naudotoja");
		System.out.println("2. Isvesti pagal id");
		choice = Integer.parseInt(buffReader.readLine());

		if (choice == 1) {
			System.out.println("Iveskite varda");
			name = buffReader.readLine();
			System.out.println("Iveskite pavarde");
			surname = buffReader.readLine();
			System.out.println("Iveskite telefono numeri");
			phoneNumber = buffReader.readLine();
			System.out.println("Iveskite elektronini pasta");
			email = buffReader.readLine();
			System.out.println("Iveskite adresa");
			address = buffReader.readLine();
			System.out.println("Iveskite slaptazodi");
			password = buffReader.readLine();

			System.out.println("Patvirtinkite irasydami 1(taip) arba 0(ne)");
			confirm = Integer.parseInt(buffReader.readLine());

			if (confirm == 1) {
				System.out.println(userService.createUser(name, surname, phoneNumber, email, address, password,"3_uzduotis/users.txt"));
				start();
			} 
		}
		if (choice == 2) {
			int id;
			System.out.println("Iveskite id");
			id = Integer.parseInt(buffReader.readLine());
			System.out.println(userService.findUserById(id,"3_uzduotis/users.txt"));
			
			start();
		}
	}

}
