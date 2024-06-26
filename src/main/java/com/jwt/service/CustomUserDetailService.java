package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.entities.User;
import com.jwt.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		//load user from database
		
		User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
		
		
		
		
		return user;
	}

}
