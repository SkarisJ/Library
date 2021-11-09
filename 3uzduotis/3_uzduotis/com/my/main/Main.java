package com.my.main;

import java.io.IOException;

import com.my.main.controllers.UserController;

public class Main {

	public static void main(String[] args) throws IOException {
		UserController userController = new UserController();

		userController.start();
	}

}
