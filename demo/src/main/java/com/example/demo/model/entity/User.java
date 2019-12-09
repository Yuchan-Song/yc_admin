package com.example.demo.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity	// = 테이블
@Table(name = "user")	// 클래스명과 테이블명이 같으면 생략이 가능
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // PK관리 전략 설정
	private long id;

	@Column(name="account")	// 컬럼명과 변수명이 다를 때 매칭 시키는 어노테이션 ( java에서는 camel case, db에서는 snake case )
	private String account;
	private String email;
	private String phoneNumber;
	private LocalDateTime createdAt;
	private String createdBy;
	private LocalDateTime updatedAt;
	private String updatedBy;
}
