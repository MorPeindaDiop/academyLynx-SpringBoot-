package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.User;
import it.jac.lynx.service.UserService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	
	@PostMapping(path="/signIn")
	public Response<?> findUserByUsernamePassword(
			@RequestBody String username){
		log.info("trova da id");
		log.info("USERNAME --->"+username);
		
		String user=null;
		int pos1 = 0, pos2 = 0;//user
		String passw=null;
		int pos3=0, pos4=0;
		
		
		log.info("lunghezza: "+username.length());
		
		int[] array=new int[9];
		int conta=0;
		for(int i=0; i<username.length(); i++) {
			if(username.charAt(i)=='"') {
				array[conta]=i;
				log.info("array di conta->"+array[conta]);
				conta++;
			}
			log.info("i vale-->"+i);
		}
		log.info("pos1: "+array[4]+"\n"+
				"pos2: "+array[5]+"\n"+
				"pos3: "+array[6]+"\n"+
				"pos4: "+array[8]+"\n");
		log.info("\n\n\n\nLA MADONNA\n\n\n\n");
		
		
		
		user=username.substring(array[2]+1,array[3]);
		passw=username.substring(array[6]+1,array[7]);
		
		
		log.info("dato1-->"+username.substring(array[2]+1,array[3]));
		log.info("dato2-->"+username.substring(array[6]+1,array[7]));

        
        log.info("USERNAME: "+user+" PASSWORD: "+passw);
		
		return userService.findUserByUsernameAndPassword(user, passw);
	}
	


}
