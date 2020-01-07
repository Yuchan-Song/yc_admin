package com.example.demo.model.network.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUserApiResponse {
	private Long id;
	
	private int loginFailCount;
	
	private String account;
	private String password;
	private String status;
	private String role;
	private String createdBy;
	private String updatedBy;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime lastLoginAt;
	private LocalDateTime passwordUpdatedAt;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
}
