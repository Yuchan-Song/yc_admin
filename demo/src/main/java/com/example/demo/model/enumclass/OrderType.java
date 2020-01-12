package com.example.demo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {
	
	ALL(1, "묶음", "묶음"),
	EACH(2, "개별", "개별");
	
	private Integer id;
	private String title;
	private String description;

}
