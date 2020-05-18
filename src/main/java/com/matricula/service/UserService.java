package com.matricula.service;

import com.matricula.model.entity.Account;

public interface UserService {
	
	Account findById(Long id);
	
	Account findByUserName(String userName);

}
