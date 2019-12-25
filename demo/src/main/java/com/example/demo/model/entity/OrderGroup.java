package com.example.demo.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Table(name = "order_group")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderDetailList", "user"})
public class OrderGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int totalPrice;
	private int totalQuantity;
	
	private String createdBy;
	private String updatedBy;
	private String orderType;
	private String paymentType;
	private String revAdress;
	private String revName;
	private String status;
	
	private LocalDateTime orderAt;
	private LocalDateTime arrivalDate;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	// OrderGrou N : 1 userp
	@ManyToOne
	private User user;
	
	// OrderGroup 1 : N OrderDetail
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
	private List<OrderDetail> orderDetailList;
}
