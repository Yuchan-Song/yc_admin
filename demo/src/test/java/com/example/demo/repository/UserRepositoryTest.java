package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.User;

public class UserRepositoryTest extends DemoApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
//	@Test
	public void create() {
		String account = "Test01";
		String password = "Test01";
		String status = "REG";
		String email = "Test01@gmail.com";
		String phoneNumber = "010-1111-2222";
		String createdBy = "Admin";
		String registeredBy = "Admin";

		LocalDateTime registeredAt = LocalDateTime.now();
		LocalDateTime createdAt = LocalDateTime.now();
		
		User user = new User();
		
		user.setAccount(account);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(password);
		user.setStatus(status);
		user.setEmail(email);
		user.setCreatedBy(createdBy);
		user.setCreatedAt(createdAt);
		user.setRegisteredBy(registeredBy);
		user.setRegisteredAt(registeredAt);
		
		User newUser = userRepository.save(user);
		assertNotNull(newUser);
	}
	
	@Test
	public void read() {
		User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
		assertNotNull(user);
		
		user.getOrderGroupList().stream().forEach(orderGroup ->{
			System.out.println(orderGroup.getRevAdress());
			System.out.println(orderGroup.getTotalPrice());
		});
	}

}
