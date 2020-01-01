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
		String registeredBy = "Admin";

		LocalDateTime registeredAt = LocalDateTime.now();
		
		User user = new User();
		user.setAccount(account);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(password);
		user.setStatus(status);
		user.setEmail(email);
		user.setRegisteredBy(registeredBy);
		user.setRegisteredAt(registeredAt);
		
		// User에 Builder annotation을 추가하여 아래와 같이 user 객체 생성이 가능하다
		// 기존의 생성자
		User user2 = User.builder()
					.account(account)
					.password(password)
					.status(status)
					.email(email)
					.build();
		
		User newUser = userRepository.save(user);
		assertNotNull(newUser);
	}
	
//	@Test
	public void read() {
		User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
		assertNotNull(user);
		
		user.getOrderGroupList().stream().forEach(orderGroup ->{
			System.out.println(orderGroup.getRevAdress());
			System.out.println(orderGroup.getTotalPrice());
		});
	}

}
