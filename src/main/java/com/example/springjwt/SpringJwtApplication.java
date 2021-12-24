package com.example.springjwt;

import com.example.springjwt.Service.UserService;
import com.example.springjwt.domain.Role;
import com.example.springjwt.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
		//System.out.println('x');

	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Kennedy", "john",
					"1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Tobi D", "tobi",
					"1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Smith Pan", "smith",
					"1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ade Saka", "ade",
					"1234", new ArrayList<>()));

			userService.addRoleToUser("tobi", "ROLE_USER");
			userService.addRoleToUser("tobi", "ROLE_MANAGER");
			userService.addRoleToUser("tobi", "ROLE_ADMIN");
			userService.addRoleToUser("tobi", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_ADMIN");
			userService.addRoleToUser("smith", "ROLE_ADMIN");
			userService.addRoleToUser("ade", "ROLE_MANAGER");
		};
	}

}
