package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.AdminUser;

public class AdminUserRepositoryTest extends DemoApplicationTests{

	@Autowired
	AdminUserRepository adminUserRepository;
	
	@Test
	public void create() {
		
		AdminUser adminUser = new AdminUser();
		
		adminUser.setAccount("adminUser01");
		adminUser.setPassword("adminUser01");
		adminUser.setStatus("Registered");
		adminUser.setRole("Partner");
		
		AdminUser newAdminUser = adminUserRepository.save(adminUser);
		assertNotNull(newAdminUser);
		
	}

}
