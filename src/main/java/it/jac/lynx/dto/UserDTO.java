package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.User;
import lombok.Data;

@Data
public class UserDTO {

	private int id;

	private String username;

	private String password;

	private String roles;
	
	public static UserDTO build(User user) {

		UserDTO result = new UserDTO();
		BeanUtils.copyProperties(user, result);

		return result;
	}
	
}
