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

import com.example.demo.model.enumclass.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Table(name = "order_group")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderDetailList", "user"})
@Builder
@Accessors(chain = true)
public class OrderGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int totalPrice;
	private int totalQuantity;
	
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String updatedBy;
	private String orderType;
	private String paymentType;
	private String revAddress;
	private String revName;
	private OrderStatus status;
	
	private LocalDateTime orderAt;
	private LocalDateTime arrivalDate;
	@CreatedDate
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	// OrderGrou N : 1 userp
	@ManyToOne
	private User user;
	
	// OrderGroup 1 : N OrderDetail
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
	private List<OrderDetail> orderDetailList;
}
