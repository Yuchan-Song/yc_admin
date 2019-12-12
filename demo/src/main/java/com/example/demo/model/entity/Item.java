package com.example.demo.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	private String name;
	private String title;
	private String content;
	private Integer price;
	private String brandName;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	private String createdBy;
	private LocalDateTime createdAt;
	private String updatedBy;
	private LocalDateTime updatedAt;
	private Long partnerId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<OrderDetail> orderDetailList;
}
