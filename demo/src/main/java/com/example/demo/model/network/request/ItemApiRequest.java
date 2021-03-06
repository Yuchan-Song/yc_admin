package com.example.demo.model.network.request;

import java.time.LocalDateTime;

import com.example.demo.model.enumclass.ItemStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemApiRequest {
	
	private Long id;
	private Long partnerId;

	private int price;

	private ItemStatus status;
	
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
