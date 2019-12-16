package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	// Query Method 구현
	
	// account 검색
	// select * from user where account = ?
	Optional<User> findByAccount(String account);
	
	// email 검색
	// select * from user where email = ?
	Optional<User> findByEmail(String email);
	
	// account와 email 검색
	// select * from user where account = ? and email = ?
	Optional<User> findByAccountAndEmail(String account, String email);

}
