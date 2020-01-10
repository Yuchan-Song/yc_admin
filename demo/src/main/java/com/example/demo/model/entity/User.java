package com.example.demo.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.demo.model.enumclass.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Table(name = "user")	// 클래스명과 테이블명이 같으면 생략이 가능
@Entity	// = 테이블
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderGroupList"})
@Builder
@Accessors(chain = true)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // PK관리 전략 설정 
	private long id;

//	@Column(name="account")	// 컬럼명과 변수명이 다를 때 매칭 시키는 어노테이션 ( java에서는 camel case, db에서는 snake case )
	private String account;
	private String email;
	private String phoneNumber;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String updatedBy;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserStatus status;		// REGISTERED, UNREGISTERED, WAITING 등등
	private String registeredBy;
	
	@CreatedDate
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	
	// OrderDetail과 User는 N : 1관계, 양객체 모두에 annotation을 설정해야한다.
	// User 1 : N OrderGroup
	// mappedBy : 어떤 객체와 연결을 시킬 것인지 지정 OrderDetail에 선언한 변수명과 동일해야 한다.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<OrderGroup> orderGroupList;
}
