package com.example.demo.model.network.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerApiRequest {
	
	private Long id;
	private Long CategoryId;
	
	private String address;
	private String businessNumber;
	private String callCenter;
	private String ceoName;
	private String name;
	private String status;
	private String partnerNumber;
	private String createdBy;
	private String updatedBy;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	
}
