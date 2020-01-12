package com.example.demo.model.network.response;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.model.entity.User;
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
public class OrderGroupApiResponse {

	private Long id;
	private Long userId;
	private User user;
	
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
	
	private List<ItemApiResponse> itemApiResponseList;
	
}
