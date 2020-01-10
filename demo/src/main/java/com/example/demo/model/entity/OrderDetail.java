package com.example.demo.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"item", "orderGroup"})
@Builder
@Accessors(chain = true)
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantity;
	private int price;

	private String status;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String updatedBy;
	
	private LocalDateTime arrivalDate;
	@CreatedDate
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	// OrderDetail N : 1 Item
	@ManyToOne
	private Item item;
	
	// 주문의 입장에서는 자기 자신이 N이고 userid가 1이기 때문에 ManyToOne annotation을 사용한다. 객체 자체를 설정해야 한다 hibernate에서는 userId로 인식
	// OrderDetail N : 1 OrderGroup
	@ManyToOne
	private OrderGroup orderGroup;

}
