package com.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.entities.User;
import com.jwt.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//inmemory
	
//	private List<User> store= new ArrayList<>();
	
//	public UserService() {
//		store.add(new User(UUID.randomUUID().toString(),"Richa","richa@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"Ritik","ritik@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"Reena","reena@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"Sanjay","sanjay@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"Abhishek","abhishek@gmail.com"));
//	}
	
	
//	public List<User> getUser()
//	{
//		return this.store;
//		
//	}
	
	
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
		
		
	}

}
