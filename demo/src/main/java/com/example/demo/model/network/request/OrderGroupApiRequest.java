package com.example.demo.model.network.request;

import java.time.LocalDateTime;

import com.example.demo.model.enumclass.OrderStatus;
import com.example.demo.model.enumclass.OrderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderGroupApiRequest {

	private Long id;
	private Long userId;
	
	private int totalPrice;
	private int totalQuantity;
	
	private String createdBy;
	private String updatedBy;
	private String paymentType;
	private String revAddress;
	private String revName;
	
	private OrderType orderType;
	private OrderStatus status;
	
	private LocalDateTime orderAt;
	private LocalDateTime arrivalDate;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
