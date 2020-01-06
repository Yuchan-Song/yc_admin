package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.entity.OrderGroup;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.OrderGroupApiRequest;
import com.example.demo.model.network.response.OrderGroupResponse;
import com.example.demo.repository.OrderGroupRepository;

@Service
public class OrderGroupLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupResponse> {

	@Autowired
	private OrderGroupRepository orderGroupRepository;
	
	@Override
	public Header<OrderGroupResponse> create(Header<OrderGroupApiRequest> request) {
		return null;
	}

	@Override
	public Header<OrderGroupResponse> read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<OrderGroupResponse> update(Header<OrderGroupApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Header delete(Long id) {
		return orderGroupRepository.findById(id)
				.map(orderGroup -> {
					orderGroupRepository.deleteById(id);
					return Header.OK();
				})
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@SuppressWarnings("unused")
	private Header<OrderGroupResponse> response(OrderGroup orderGroup) {
		OrderGroupResponse orderGroupResponse = OrderGroupResponse.builder()
												.id(orderGroup.getId())
												.userId(orderGroup.getUser().getId())
												.totalPrice(orderGroup.getTotalPrice())
												.totalQuantity(orderGroup.getTotalQuantity())
												.status(orderGroup.getStatus())
												.orderType(orderGroup.getOrderType())
												.revAdress(orderGroup.getRevAdress())
												.revName(orderGroup.getRevName())
												.paymentType(orderGroup.getPaymentType())
												.createdBy(orderGroup.getCreatedBy())
												.createdAt(orderGroup.getCreatedAt())
												.updatedBy(orderGroup.getUpdatedBy())
												.updatedAt(orderGroup.getUpdatedAt())
												.arrivalDate(orderGroup.getArrivalDate())
												.orderAt(orderGroup.getOrderAt())
												.build();
		
		return Header.OK(orderGroupResponse);
	}
	
}
