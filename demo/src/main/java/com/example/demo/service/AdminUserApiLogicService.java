package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.entity.AdminUser;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.AdminUserApiRequest;
import com.example.demo.model.network.response.AdminUserApiResponse;
import com.example.demo.repository.AdminUserRepository;

public class AdminUserApiLogicService implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse>{
	
	@Autowired
	private AdminUserRepository adminUserRepository;

	@Override
	public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
		AdminUserApiRequest body = request.getData();
		
		AdminUser adminUser = AdminUser.builder()
							  .loginFailCount(0)
							  .account(body.getAccount())
							  .status(body.getStatus())
							  .role(body.getRole())
							  .createdBy("ADMIN")
							  .createdAt(LocalDateTime.now())
							  .registeredAt(LocalDateTime.now())
							  .build();
		
		AdminUser newAdminUser = adminUserRepository.save(adminUser);
		
		return response(newAdminUser);
	}

	@Override
	public Header<AdminUserApiResponse> read(Long id) {
		return adminUserRepository.findById(id)
				.map(adminUser -> response(adminUser))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
		AdminUserApiRequest body = request.getData();
		return adminUserRepository.findById(body.getId())
				.map(adminUser -> {
					adminUser.setStatus(body.getStatus())
							.setRole(body.getRole())
							.setUpdatedAt(LocalDateTime.now())
							.setUpdatedBy("ADMIN");
					return adminUser;
				})
				.map(adminUser -> adminUserRepository.save(adminUser))
				.map(adminUser -> response(adminUser))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	@SuppressWarnings({"rawtypes"})
	public Header delete(Long id) {
		return adminUserRepository.findById(id)
				.map(adminUser -> {
					adminUserRepository.deleteById(id);
					return Header.OK();
				})
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}
	
	@SuppressWarnings("unused")
	private Header<AdminUserApiResponse> response(AdminUser adminUser) {
		AdminUserApiResponse adminUserApiResponse = AdminUserApiResponse.builder()
													.id(adminUser.getId())
													.loginFailCount(adminUser.getLoginFailCount())
													.account(adminUser.getAccount())
													.status(adminUser.getStatus())
													.role(adminUser.getRole())
													.createdBy(adminUser.getCreatedBy())
													.createdAt(adminUser.getCreatedAt())
													.updatedBy(adminUser.getUpdatedBy())
													.updatedAt(adminUser.getUpdatedAt())
													.lastLoginAt(adminUser.getLastLoginAt())
													.registeredAt(adminUser.getRegisteredAt())
													.build();
		
		return Header.OK(adminUserApiResponse);
	}

}
