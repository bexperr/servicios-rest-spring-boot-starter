package com.bexperr.users.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bexperr.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByUsernameAndPassword(String username,String password);

	@Query("SELECT u.username FROM User u")
	public Page<String> findUserNames(PageRequest pageRequest);

}
