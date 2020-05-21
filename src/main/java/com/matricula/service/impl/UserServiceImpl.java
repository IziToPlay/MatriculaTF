package com.matricula.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	@Override
	public Account getLoggedUser() {
		//Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
		UserDetails loggedUser = null;

		//Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;
		}
		
		Account myUser = userRepository.findByUserName(loggedUser.getUsername());
		
		return myUser;
	}

}
