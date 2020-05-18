package com.matricula.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.model.entity.Account;
import com.matricula.model.repository.UserRepository;
import com.matricula.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Account findById(Long id) {
		return userRepository.fetchById(id);
	}

	@Override
	public Account findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
