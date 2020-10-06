package com.bexperr.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bexperr.users.model.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}
