package com.example.demo.model.network.request;

import java.time.LocalDateTime;

import com.example.demo.model.enumclass.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailApiRequest {
	
	private Long id;
	private Long orderGroupId;

	private int quantity;
	private int price;

	private OrderStatus status;
	private String createdBy;
	private String updatedBy;
	
	private LocalDateTime arrivalDate;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
