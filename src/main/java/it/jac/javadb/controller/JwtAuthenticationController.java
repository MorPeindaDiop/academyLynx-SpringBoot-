package it.jac.javadb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.javadb.dto.JwtAuthenticationReqDTO;
import it.jac.javadb.util.JwtTokenUtil;

//controller che consentono la generazione del token di autenticazione, necessario per superare il 
//filtro implementato nella classe JwtRequestFilter

@RestController
@RequestMapping("/auth")
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;

	//il path diventa localhost:8080/auth/token
	@PostMapping("/token")
	public ResponseEntity<String> createAuthenticationToken(@RequestBody JwtAuthenticationReqDTO authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		//controlliamo che psw e username siano corretti
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		//generiamo il token
		
		return ResponseEntity.ok(token);
	}

	private void authenticate(String username, String password) throws Exception {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
	}
}