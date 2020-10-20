package it.jac.javadb.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.jac.javadb.dao.UserRepository;
import it.jac.javadb.entity.User;

// Classe utilizzata per verificare le credenziali inserite dall'utente in fase di login

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
        if (user == null) {
        	throw new UsernameNotFoundException(username);
        }
        //in caso lo username non esistesse, si genera una eccezione
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        String roles = user.getRoles();
        //prendiamo tutti i ruoli del nostro utente
        String[] tokens = roles.split(";");
        for(String role : tokens) {
        	grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()), grantedAuthorities);    
	}
}
