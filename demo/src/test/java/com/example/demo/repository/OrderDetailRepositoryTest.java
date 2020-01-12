package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.OrderDetail;
import com.example.demo.model.entity.User;

public class OrderDetailRepositoryTest extends DemoApplicationTests {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Test
	public void create() {
		Optional<User> user = userRepository.findById(1L);
		
		user.ifPresent(orderUser -> {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setItem(new Item());
			orderDetail.setCreatedBy("testUser");
			orderDetail.setArrivalDate(LocalDateTime.now());
			orderDetail.setCreatedAt(LocalDateTime.now());
			orderDetail.setPrice(1000000);
		
			OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
			assertNotNull(newOrderDetail);
		});
	}

}
