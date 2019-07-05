package com.springboot.regis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.regis.model.User;
import com.springboot.regis.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public User findByRegno(String regno) {
		return userRepository.findByRegno(regno);
	}
}
