package com.bexperr.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.bexperr.users.repository.UserRepository;
import com.bexperr.users.repository.RoleRepository;
import com.bexperr.users.model.User;
import com.bexperr.users.model.Role;

@SpringBootApplication
public class UsersAppApplication implements ApplicationRunner{
	
	@Autowired
	private Faker faker;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role roles[] = {new Role("ADMIN"),new Role("SUPPORT"),new Role("USER")};
		
		for(Role role : roles) {
			roleRepository.save(role);
		}
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			user.setProfile(null);
			repository.save(user);
		}
		
	}

}
