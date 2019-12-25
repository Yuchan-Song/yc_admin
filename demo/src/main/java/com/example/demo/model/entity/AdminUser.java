package com.example.demo.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Table(name = "admin_user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // AuditingEntityListener의 클래스에 의해서 LoginUserAuditorAware에서 리턴된 값이 createdby, lastmodifiedby에 설정
@Builder
@Accessors(chain = true)
public class AdminUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int loginFailCount;
	
	private String account;
	private String password;
	private String status;
	private String role;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String updatedBy;
	
	@CreatedDate
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	private LocalDateTime lastLoginAt;
	private LocalDateTime passwordUpdatedAt;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	
}
