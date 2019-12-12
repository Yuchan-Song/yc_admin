package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.Item;

public class ItemRepositoryTest extends DemoApplicationTests {
	
	@Autowired
	private ItemRepository itemRepository;

//	@Test
	public void create() {
		Item item = new Item();
		item.setName("노트북");
		item.setPrice(1000000);
		item.setTitle("노트북구매");
		item.setContent("LG 노트북 Gram");
		item.setPartnerId(10L);
		
		Item newItem = itemRepository.save(item);
		assertNotNull(newItem); 
	}
	
	@Test
	public void read() {
		Long id = 1L;
		
		Optional<Item> item = itemRepository.findById(id);
		item.ifPresent(i -> {
			System.out.println(i);
		});
	}
	
}
