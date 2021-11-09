package com.my.main.repositories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.my.main.models.UserModel;

public class UserRepository {

	private static FileWriter writer;

	public UserRepository() {

	}

	public String createUser(String path, UserModel user) throws IOException {
		writer = new FileWriter(path, true);
		writer.write(format(path, user));
		writer.close();

		return formatReturn(path, user);
	}

	@SuppressWarnings("resource")
	public String findUserById(String path, int id) throws IOException {
		FileInputStream fstream = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String line = "";
		while ((line = br.readLine()) != null) {
			if (getId(line).equals(id)) {
				fstream.close();
				return line;
			}

		}
		fstream.close();

		return "Naudotojas nerastas";
	}
	private String format(String path, UserModel user) throws IOException {

		return "Id: " + increaseId(path) + ";" + "Name: " + user.getName() + ";" + "Surname: " + user.getSurname() + ";"
				+ "Phone number: " + user.getPhoneNumber() + ";" + "Email: " + user.getEmail() + ";" + "Address: "
				+ user.getAddress() + ";" + "Password: " + user.getPassword() + ";\n";
	}

	private String formatReturn(String path, UserModel user) throws IOException {

		return "Id: " + (increaseId(path) - 1) + ";" + "Name: " + user.getName() + ";" + "Surname: " + user.getSurname()
				+ ";" + "Phone number: " + user.getPhoneNumber() + ";" + "Email: " + user.getEmail() + ";" + "Address: "
				+ user.getAddress() + ";" + "Password: " + user.getPassword() + ";\n";
	}

	@SuppressWarnings("resource")
	public Integer increaseId(String fileName) throws IOException {
		FileInputStream fstream = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		if (new File(fileName).length() == 0)
			return 1;

		String currentLine = "";
		String previousLine = "";
		while ((currentLine = br.readLine()) != null) {
			previousLine = currentLine;
		}
		;

		fstream.close();

		return getId(previousLine) + 1;
	}

	public Integer getId(String line) {
		line = line.substring(4, line.length());
		int separatorIndex = line.indexOf(";");

		return Integer.parseInt(line.substring(0, separatorIndex));
	}
}
