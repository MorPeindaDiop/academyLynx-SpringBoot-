package it.jac.lynx.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.jac.lynx.entity.User;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void createUserTest() {
		User user = new User();
		user.setUsername("pippo");
		user.setPassword("1234");
		assertEquals(true, userService.createUser(user).isResultTest());
	}
	
	
	@Test 
	public void deleteUserlByIdTest() {	
			assertEquals("User eliminato.", userService.deleteUserById(2).getResult());
	}
	
	
	@Test
	public void findAllUsersTest() {
		assertEquals(true, userService.findAllUsers().isResultTest());
	}
	
	@Test
	public void findCandidateByIdTest() {
		assertEquals(true, userService.findUserById(1).isResultTest());
	}
	
	@Test
	public void findByUsernamePassword() {
		assertEquals(true, userService.findUserByUsernameAndPassword("pippo","pippo").isResultTest());
	}
	

}
