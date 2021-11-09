import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.my.main.models.UserModel;
import com.my.main.repositories.UserRepository;

public class UserRepositoryTest {

	UserRepository repository;

	@BeforeEach
	public void setUp() {
		repository = new UserRepository();
	}

	@Test
	public void createUserTest() throws IOException {

		String testFile = "3_uzduotis/testFile.txt";
		File object = new File(testFile);
		object.createNewFile();
		UserModel user = new UserModel("vardas", "pavarde", "+37061223456", "email@gmail.com", "address", "Password*");
		repository.createUser(testFile, user);

		assertTrue(repository.findUserById(testFile, 1).equals(
				"Id: 1;Name: vardas;Surname: pavarde;Phone number: +37061223456;Email: email@gmail.com;Address: address;Password: Password*;"));
	}

	@Test
	public void findUserByIdTest() throws IOException {

		String testFile = "3_uzduotis/testFile.txt";
		File object = new File(testFile);
		object.createNewFile();
		UserModel user = new UserModel("vardas", "pavarde", "+37061223456", "email@gmail.com", "address", "Password*");
		repository.createUser(testFile, user);

		String line = repository.findUserById(testFile, 1);
		assertEquals(
				"Id: 1;Name: vardas;Surname: pavarde;Phone number: +37061223456;Email: email@gmail.com;Address: address;Password: Password*;",
				line);

	}

}
