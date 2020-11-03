package it.jac.lynx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "it.jac.lynx")
public class LynxApplication {

	public static void main(String[] args) {
		SpringApplication.run(LynxApplication.class, args);
	}

}
