package com.bexperr.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bexperr.users.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

}
