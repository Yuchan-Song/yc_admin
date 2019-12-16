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
	private Long id;

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
	
	// Fetch 타입
	// LAZY : 지연로딩 - select * from item where id = ? : 선택한 id에 대해서만 select : 연관관계가 설정된 테이블의 정보를 함께 가져오지 않는다.
	// EAGER : 즉시로딩 - select *  ffrom item left outer join order_detail on ... left outer join user on ... where id = ? : 연관관계가 설정된 테이블과 조인 후 id로 select
	//		 : 연관관계가 1:N 인경우 성능의 저하가 우려되기 때문에 주로 1:1 관계일 때만 사용하는 것을 추천
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<OrderDetail> orderDetailList;
}
