package com.example.demo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {
	
	REGISTERED(1, "등록", "등록 상태"),
	UNREGISTERED(2, "해지", "해지 상태"),
	WAITING(3, "검수중", "등록 대기 상태");
	
	private Integer id;
	private String title;
	private String description;
	

}
