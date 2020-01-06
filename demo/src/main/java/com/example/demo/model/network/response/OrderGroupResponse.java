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
public class OrderGroupResponse {

	private Long id;
	private Long userId;
	
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
	
}