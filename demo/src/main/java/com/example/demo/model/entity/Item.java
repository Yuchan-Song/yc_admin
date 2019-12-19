package com.example.demo.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long partnerId;

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
	
	// Fetch 타입
	// LAZY : 지연로딩 - select * from item where id = ? : 선택한 id에 대해서만 select : 연관관계가 설정된 테이블의 정보를 함께 가져오지 않는다.
	// EAGER : 즉시로딩 - select *  ffrom item left outer join order_detail on ... left outer join user on ... where id = ? : 연관관계가 설정된 테이블과 조인 후 id로 select
	//		 : 연관관계가 1:N 인경우 성능의 저하가 우려되기 때문에 주로 1:1 관계일 때만 사용하는 것을 추천
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<OrderDetail> orderDetailList;
}
