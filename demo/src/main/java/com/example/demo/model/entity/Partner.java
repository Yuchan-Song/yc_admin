package com.example.demo.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Table(name = "partner")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"itemList", "category"})
@Builder
@Accessors(chain = true)
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	private String businessNumber;
	private String callCenter;
	private String ceoName;
	private String name;
	private String status;
	private String partnerNumber;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String updatedBy;
	
	@CreatedDate
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	
	// Partner 1 : N Item
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
	private List<Item> itemList;
	
	// Partner N : 1 Category
	@ManyToOne
	private Category category;
}
