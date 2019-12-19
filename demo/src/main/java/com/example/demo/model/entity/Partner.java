package com.example.demo.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "partner")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long categoryId;
	
	private String address;
	private String businessNumber;
	private String callCenter;
	private String ceoName;
	private String createdBy;
	private String updatedBy;
	private String name;
	private String status;
	private String partnerNumber;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime registereddAt;
	private LocalDateTime unregistereddAt;
	
}
