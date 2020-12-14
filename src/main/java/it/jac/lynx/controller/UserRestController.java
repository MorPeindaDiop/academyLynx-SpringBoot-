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
		log.info(username);
		
//		JSONObject jsonObject1;
//		String value1 = null;
//        String value2 = null;
//        log.info(username.substring(2,username.length()-2));
//		
//		JSONArray jsonArray = new JSONArray(username.substring(2,username.length()-3));
//		
//		for(int i=0;i<jsonArray.length();i++)
//        {
//            jsonObject1 = jsonArray.getJSONObject(i);
//            value1 = jsonObject1.optString("username");
//            value2 = jsonObject1.optString("password");
//        }
//		log.info(value1);
//		username.optString("username");
		
		JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            json = (JSONObject) parser.parse(username);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        log.info(json.toString());
		
		return userService.findUserByUsernameAndPassword(json.toString(), json.toString());
	}
	
//	@PostMapping(path="/signIn")
//	public Response<?> findUserByUsername(
//			@RequestBody String username){
//		log.info("trova da id");
//		log.info(username);
//		
//		return userService.findUserByUsername(username);
//	}
	
	

}
