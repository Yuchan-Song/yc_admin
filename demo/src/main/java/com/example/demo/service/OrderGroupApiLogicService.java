package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.entity.OrderGroup;
import com.example.demo.model.entity.User;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.OrderGroupApiRequest;
import com.example.demo.model.network.response.OrderGroupResponse;
import com.example.demo.repository.OrderGroupRepository;

@Service
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupResponse> {

	@Autowired
	private OrderGroupRepository orderGroupRepository;
	
	@Override
	public Header<OrderGroupResponse> create(Header<OrderGroupApiRequest> request) {
		OrderGroupApiRequest body = request.getData();

		User user = User.builder().id(body.getUserId()).build();

		OrderGroup orderGroup = OrderGroup.builder()
								.totalPrice(body.getTotalPrice())
								.totalQuantity(body.getTotalQuantity())
								.status(body.getStatus())
								.orderType(body.getOrderType())
								.revAdress(body.getRevAdress())
								.revName(body.getRevName())
								.paymentType(body.getPaymentType())
								.createdBy(body.getCreatedBy())
								.createdAt(body.getCreatedAt())
								.updatedBy(body.getUpdatedBy())
								.updatedAt(body.getUpdatedAt())
								.arrivalDate(body.getArrivalDate())
								.orderAt(body.getOrderAt())
								.user(user)
								.build();
	
		OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
		
		return response(newOrderGroup);
	}

	@Override
	public Header<OrderGroupResponse> read(Long id) {
		return orderGroupRepository.findById(id)
				.map(orderGroup -> response(orderGroup))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<OrderGroupResponse> update(Header<OrderGroupApiRequest> request) {
		
		OrderGroupApiRequest body = request.getData();
		
		return orderGroupRepository.findById(body.getId())
				.map(orderGroup -> {
					orderGroup.setTotalPrice(body.getTotalPrice())
						.setTotalQuantity(body.getTotalQuantity())
						.setStatus(body.getStatus())
						.setOrderType(body.getOrderType())
						.setRevAdress(body.getRevAdress())
						.setRevName(body.getRevName())
						.setUpdatedAt(LocalDateTime.now())
						.setUpdatedBy("ADMIN")
						.setArrivalDate(LocalDateTime.now());
					
					return orderGroup;
				})
				.map(orderGroup -> orderGroupRepository.save(orderGroup))
				.map(orderGroup -> response(orderGroup))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	@SuppressWarnings({"rawtypes"})
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
