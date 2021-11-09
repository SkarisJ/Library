import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.my.main.services.UserService;

class UserServiceTest {

	UserService service;

	@BeforeEach
	public void setUp() {
		service = new UserService();
	}

	@Test
	public void createUsertest() throws IOException {
		service.createUser("vardas", "pavarde", "+37061223456", "email@gmail.com", "address", "Password*1",
				"3_uzduotis/testFile.txt");

		assertTrue(service.findUserById(1, "3_uzduotis/testFile.txt").equals(
				"Id: 1;Name: vardas;Surname: pavarde;Phone number: +37061223456;Email: email@gmail.com;Address: address;Password: Password*1;"));
	}

	@Test
	public void findUserbyIdtest() throws IOException {

		String line = service.findUserById(1, "3_uzduotis/testFile.txt");
		assertEquals(
				"Id: 1;Name: vardas;Surname: pavarde;Phone number: +37061223456;Email: email@gmail.com;Address: address;Password: Password*1;",
				line);
	}

}
