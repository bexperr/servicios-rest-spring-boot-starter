package com.bexperr.users.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bexperr.users.repository.UserRepository;

import com.bexperr.users.model.User;

@Service
public class UserService {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	
	@Autowired
	private UserRepository repository;
	
	public Page<User> getUsers(int page, int size){
		return repository.findAll(PageRequest.of(page, size));
//		return repository.findAll();
	}
	
	public User getUserById(Integer userId) {
		log.info("getUserById {} ", userId);
		return repository.findById(userId).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %d not found", userId)));
	}
	
	@Cacheable("users")
	public User getUserByUsername(String username) {
		log.info("Gettin user by username {}",username);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return repository.findByUsername(username).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %s not found", username)));
	}
	
	@CacheEvict("users")
	public void deleteUserByUsername(String username) {
		User user = getUserByUsername(username);
		repository.delete(user);
	}
	
	public User getUsernameAndPassword(String username,String password) {
		return repository.findByUsernameAndPassword(username, password).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %s not found", username)));
	}

	public Page<String> getUsernames(int page, int size) {
		return repository.findUserNames(PageRequest.of(page, size));
	}

}
