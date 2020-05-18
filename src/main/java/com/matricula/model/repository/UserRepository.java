package com.matricula.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.Account;

@Repository
public interface UserRepository extends JpaRepository<Account, Long>{
	
	@Query("SELECT a FROM Account a WHERE a.userName like %?1%")
	Account findByUserName(String userName);
	
	@Query("SELECT a FROM Account a WHERE a.id=?1")
	Account fetchById(Long id);
	
}
