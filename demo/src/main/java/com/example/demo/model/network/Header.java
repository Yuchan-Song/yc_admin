package com.example.demo.model.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * API 공통영역(Header)을 처리하기 위한 클래스
 * @author Yuchan
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings({"unchecked", "rawtypes"})
//@JsonInclude // 어떤 값을 include 할 지 설정하는 annotation
public class Header<T> {

	// 공통 변수 리스트 : api 통신시간
//	@JsonProperty("transaction_time")
	private LocalDateTime transactionTime;
	
	// 응답 코드
	
	private String resultCode;
	
	// 코드에 대한 부가 설명
	private String description;
	
	// data 영역은 generinc으로 선언
	private T data;
	
	// Data가 없는 OK 메소드
	public static<T> Header<T> OK() {
		return (Header)Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.build();
	}
	
	// Data가 있는 OK 메소드
	public static<T> Header<T> OK(T data) {
		return (Header)Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.data(data)
				.build();
	}
	
	// ERROR 메소드
	public static<T> Header<T> ERROR(String description) {
		return (Header)Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("ERROR")
				.description(description)
				.build();
	}
	
}
