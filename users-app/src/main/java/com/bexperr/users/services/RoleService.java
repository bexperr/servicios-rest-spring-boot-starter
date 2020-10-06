package com.bexperr.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bexperr.users.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

import com.bexperr.users.model.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public List<Role> getRoles(){
		return repository.findAll();
	}
	
	public Role createRole(Role role) {
		return repository.save(role);
	}
	
	public Role updateRole(Integer roleId,Role role) {
		Optional<Role> result = repository.findById(roleId);
		if(result.isPresent()) {
			return repository.save(role);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("Role id %d doesn´t exists", roleId));
		}
	}
	
	public void deleteRole(Integer roleId) {
		Optional<Role> result = repository.findById(roleId);
		if(result.isPresent()) {
			repository.delete(result.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("Role id %d doesn´t exists", roleId));
		}
	}
	
	
	
	

}
