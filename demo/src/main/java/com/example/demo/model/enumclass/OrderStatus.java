package com.example.demo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
	FAIL(0, "결제 실패", "결제 실패 상태"),
	PAYMENT(1, "결제 완료", "결제 완료 상태"),
	DELIVERY_REQUEST(2, "배송 요청", "배송 요청 상태"),
	DELIVERY_ING(3, "배송중", "배송 상태"),
	DELIVERY_SUCCESS(4, "배송 완료", "배송 완료 상태"),
	CHANGR_REQUEST(5, "교환 요청", "교환 요청 상태"),
	CHANGR_ING(6, "교환 진행", "교환 진행 상태"),
	CHANGR_SUCCESS(7, "교환 완료", "교환 완료 상태"),
	REFUND_REQUEST(8, "반품 요청", "반품 요청 상태"),
	REFUND_ING(9, "반품 진행", "반품 진행 상태"),
	REFUND_SUCCESS(10, "반품 완료", "반품 완료 상태"),
	ORDER_COMPLETE(11, "주문 확정", "주문 확정 상태");
	
	private Integer id;
	private String status;
	private String description;

}
