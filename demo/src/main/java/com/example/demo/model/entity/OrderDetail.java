package com.example.demo.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "item"})
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 주문의 입장에서는 자기 자신이 N이고 userid가 1이기 때문에 ManyToOne annotation을 사용한다. 객체 자체를 설정해야 한다 hibernate에서는 userId로 인식
	@ManyToOne 
	private User user;	
	
	@ManyToOne
	private Item item;

	private String status;
	private LocalDateTime arrivalDate;
	private int quantity;
	private int totalPrice;
	private LocalDateTime orderAt;
	private String createdBy;
	private LocalDateTime createdAt;
	private String updatedBy;
	private LocalDateTime updatedAt;
	private Long orderGroupId;
	

}
