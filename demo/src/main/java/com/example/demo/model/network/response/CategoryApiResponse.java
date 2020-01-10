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
public class CategoryApiResponse {

	private Long id;
	
	private String title;
	private String type;
	private String createdBy;
	private String updatedBy;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
