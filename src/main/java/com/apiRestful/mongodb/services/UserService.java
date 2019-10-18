package com.apiRestful.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiRestful.mongodb.domain.User;
import com.apiRestful.mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User>findAll(){
		return repo.findAll();
	}
}
