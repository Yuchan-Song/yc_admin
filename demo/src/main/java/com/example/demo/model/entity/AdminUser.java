package com.example.demo.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "admin_user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private LocalDateTime lastLoginDt;
	private LocalDateTime passwordUpdatedAt;
	private LocalDateTime registedAt;
	private LocalDateTime unregistedAt;
	
	
}
