package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.UserRepository;
import it.jac.lynx.dto.UserDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.User;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Response<Boolean> createUser(User user) {

		Response<Boolean> response=new Response<Boolean>();

		try {

			this.userRepository.save(user);

			response.setResult(true);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("User non creato");

		}

		return response;

	}

	public Response<String> deleteUserById(int id) {

		Response<String> response = new Response<String>();

		try {

			this.userRepository.deleteById(id);

			response.setResult("User eliminato.");
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("User non eliminato correttamente.");

		}

		return response;

	}

	public Response<List<UserDTO>> findAllUsers() {

		Response<List<UserDTO>> response = new Response<List<UserDTO>>();

		List<UserDTO> result = new ArrayList<>();

		try {

			Iterator<User> iterator = this.userRepository.findAll().iterator();

			while (iterator.hasNext()) {

				User user = iterator.next();
				result.add(UserDTO.build(user));

			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

	public Response<UserDTO> findUserById(int id) {

		Response<UserDTO> response = new Response<UserDTO>();

		try {

			User user = this.userRepository.findById(id).get();

			response.setResult(UserDTO.build(user));
			response.setResultTest(true);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;
		
	}

	public Response<List<UserDTO>> findUserByUsername(String username) {

		Response<List<UserDTO>> response = new Response<List<UserDTO>>();
		
		List<UserDTO> result = new ArrayList<>();

		try {
			
			Iterator<User> iterator = this.userRepository.findByUsername(username).iterator();
			
			while (iterator.hasNext()) {

				User user = iterator.next();
				result.add(UserDTO.build(user));
			
			}

			response.setResult(result);
			response.setResultTest(true);

		} catch (Exception e ) {
			
			response.setError("Nessun elemento trovato.");
		
		}

		return response;
		
	}
	

	public Response<List<UserDTO>> findUserByUsernamePassword(String username, String password) {

		Response<List<UserDTO>> response = new Response<List<UserDTO>>();
		
		List<UserDTO> result = new ArrayList<>();

		try {
			
			Iterator<User> iterator = this.userRepository.findByUsername(username).iterator();
			
			while (iterator.hasNext()) {

				User user = iterator.next();
				if(user.getPassword().equals(password)) {
					result.add(UserDTO.build(user));	
					response.setResult(result);
					response.setResultTest(true);

				}
				
			
			}

			
		} catch (Exception e ) {
			
			response.setError("Nessun elemento trovato.");
		
		}

		return response;
		
	}
	

	public Response<UserDTO> updateUserUsernameById(int id, String newUsername) {

		Response<UserDTO> response = new Response<UserDTO>();

		try {
			
			User user = this.userRepository.findById(id).get();

			if (user != null)
				user.setUsername(newUsername);

			this.userRepository.save(user);
			
			response.setResult(UserDTO.build(user));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
		}	

		return response;
		
	}

	public Response<UserDTO> updateUserPasswordById(int id, String newPassword) {

		Response<UserDTO> response = new Response<UserDTO>();

		try {
			
			User user = this.userRepository.findById(id).get();

			if (user != null)
				user.setPassword(newPassword);

			this.userRepository.save(user);
			
			response.setResult(UserDTO.build(user));
			response.setResultTest(true);

		} catch (Exception e) {
			
			response.setError("Nessun elemento trovato.");
			
		}	

		return response;
		
	}

}
