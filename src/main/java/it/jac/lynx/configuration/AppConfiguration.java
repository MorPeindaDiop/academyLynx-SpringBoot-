package it.jac.lynx.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/rest/candidate/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/candidateAnswer/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/candidateField/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/candidateSkill/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/field/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/question/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/seniority/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/skill/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/user/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/score/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/testQuestion/**").allowedMethods("GET", "POST");
		registry.addMapping("/rest/mail/**").allowedMethods("GET","POST");
		//registry.addMapping("/rest/user/**").allowedMethods("GET", "POST").allowedOrigins("localhost:4200/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers().permitAll()//end point senza controllo di nessun tipo, quindi accessibile ad ogni client
		.anyRequest().permitAll()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

}
