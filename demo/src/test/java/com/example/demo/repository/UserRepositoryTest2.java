package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.OrderDetail;
import com.example.demo.model.entity.User;

public class UserRepositoryTest2 extends DemoApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
//	@Test
	public void create() {
		User user = new User();
		user.setAccount("TestUser02");
		user.setEmail("TestUser02@gmail.com");
		user.setPhoneNumber("010-3333-3333");
		user.setCreatedAt(LocalDateTime.now());
		user.setCreatedBy("TestUser03");
		
		User newUser = userRepository.save(user);
		System.out.println("newUser = " + newUser);
	}
	
//	@Test
	@Transactional
	public void read() {
//		Optional<User> user = userRepository.findById(1L);
		// UserRepository에 findByAccount, findByEmail을 구현 후 사용할 수 있다.
		Optional<User> user = userRepository.findByAccount("testUser01");
		
		user.ifPresent(selectUser-> {
			selectUser.getOrderGroupList().stream().forEach(group ->{
				List<OrderDetail> orderDetail = group.getOrderDetailList();
				System.out.println(orderDetail.size());
			});
		});
	}
	
//	@Test
	public void update() {
		Optional<User> user = userRepository.findById(2L);
		user.ifPresent(selectUser-> {
			selectUser.setAccount("testUser99");
			selectUser.setUpdatedAt(LocalDateTime.now());
			selectUser.setUpdatedBy("update Method");
			// create와 동일한 save메소드를 사용해도 jpa에서 select한 user가 있는 경우 update를 해준다
			userRepository.save(selectUser);
		});
	}
	
//	@Test
	@Transactional
	public void delete() {
		Optional<User> user = userRepository.findById(4L);
		
		// user가 존재해야만 통과가 된다.
		assertTrue(user.isPresent());
		
		user.ifPresent(selectUser-> {
			// create와 동일한 save메소드를 사용해도 jpa에서 select한 user가 있는 경우 update를 해준다
			userRepository.delete(selectUser);
		});
		
		Optional<User> deleteUser = userRepository.findById(4L);
		assertFalse(deleteUser.isPresent());

	}
	
}
