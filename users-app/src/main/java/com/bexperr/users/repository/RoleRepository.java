package com.bexperr.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bexperr.users.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
