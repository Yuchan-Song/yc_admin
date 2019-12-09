package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data				// Data : private 변수에 대한 getter, setter 생성을 도와주는 annotation
@AllArgsConstructor	// AllArgsConstructor 모든 인자가 들어간 생성자를 만들어 준다
public class SearchParam {
	private String account;
	private String email;
	private int page;
}
