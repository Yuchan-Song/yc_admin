package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.Category;

public class CategoryRepositoryTest extends DemoApplicationTests{
	
	@Autowired
	CategoryRepository categoryRepository;
	
//	@Test
	public void create() {
		String type = "COMPUTER";
		String title = "컴퓨터";
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "Administer";

		Category category = new Category();
		category.setType(type);
		category.setTitle(title);
		category.setCreatedAt(createdAt);
		category.setCreatedBy(createdBy);
		
		Category newCategory = categoryRepository.save(category);
		assertNotNull(newCategory);
		assertEquals(newCategory.getType(), type);
		assertEquals(newCategory.getTitle(), title);
	}
	
//	@Test
	public void read() {
//		Optional<Category> category = categoryRepository.findById(1L);
		String type = "COMPUTER";
		Optional<Category> category = categoryRepository.findByType(type);
		
		category.ifPresent(c -> {
			assertEquals(c.getType(), type);
			System.out.println(c.getId());
		});
	}

}
