package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.Item;

public class ItemRepositoryTest extends DemoApplicationTests {
	
	@Autowired
	private ItemRepository itemRepository;

//	@Test
	public void create() {
		Item item = new Item();
		item.setName("삼성 노트북");
		item.setPrice(11000000);
		item.setTitle("삼성 노트북");
		item.setContent("2019년 신상품");
		
		Item newItem = itemRepository.save(item);
		assertNotNull(newItem); 
	}
	
//	@Test
	public void read() {
		Long id = 1L;
		
		Optional<Item> item = itemRepository.findById(id);
		assertTrue(item.isPresent());
	}
	
}
