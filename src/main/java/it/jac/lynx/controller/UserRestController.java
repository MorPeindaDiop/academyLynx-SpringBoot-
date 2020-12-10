package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.User;
import it.jac.lynx.service.UserService;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
	private static Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public Response<?> createUser(@RequestParam int id){

		log.info("Ricevuta richiesta di creazione nuovo user");

		User user= new User();
		user.setId(id);

		return userService.createUser(user);
	}
	
	
	
	@DeleteMapping(path = "/delete/{id}")
	public Response<?> deleteUserById(@PathVariable int id) {

		log.info("Richiesta delete.");

		return userService.deleteUserById(id);
	}
	
	
	@GetMapping(path="/findAll")
	public Response<?> findAllUsers(){
		
		log.info("richiesta di find all.");
		
		return userService.findAllUsers();
	}
	@GetMapping(path="/findUsersPassword/{}")
	public Response<?> findAllUsersPassword(){
		
		log.info("richiesta di find all.");
		
		return userService.findAllUsers();
	}
	
	
	@GetMapping(path="/findById/{id}")
	public Response<?> findUserById(@PathVariable int id){
		log.info("trova da id");
		
		return userService.findUserById(id);
	}
	
	@GetMapping(path="/findByUsername/{username}")
	public Response<?> findUserByUsername(@PathVariable String name){
		log.info("trova da id");
		
		return userService.findUserByUsername(name);
	}
	
	@PostMapping(path="/signIn/{username}&{password}")
	public Response<?> findUserByUsernamePassword(@PathVariable String name, @PathVariable String password){
		log.info("trova da id");
		
		return userService.findUserByUsernamePassword(name, password);
	}
	
	

}
