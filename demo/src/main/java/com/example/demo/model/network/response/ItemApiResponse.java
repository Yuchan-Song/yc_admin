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
public class ItemApiResponse {
	
	private Long id;

	private int price;
	
	private String status;
	private String name;
	private String title;
	private String content;
	private String brandName;
	private String createdBy;
	private String updatedBy;
	
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
