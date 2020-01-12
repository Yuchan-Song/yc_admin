package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.OrderGroup;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.OrderGroupApiRequest;
import com.example.demo.model.network.response.OrderGroupApiResponse;
import com.example.demo.repository.UserRepository;

@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
		
		return Optional.ofNullable(request.getData())
			.map(body -> {
				OrderGroup orderGroup = OrderGroup.builder()
						.totalPrice(body.getTotalPrice())
						.totalQuantity(body.getTotalQuantity())
						.status(body.getStatus())
						.orderType(body.getOrderType())
						.revAddress(body.getRevAddress())
						.revName(body.getRevName())
						.paymentType(body.getPaymentType())
						.createdBy(body.getCreatedBy())
						.createdAt(body.getCreatedAt())
						.updatedBy(body.getUpdatedBy())
						.updatedAt(body.getUpdatedAt())
						.arrivalDate(body.getArrivalDate())
						.orderAt(body.getOrderAt())
						.user(userRepository.getOne(body.getUserId()))
						.build();
				return orderGroup;
			})
			.map(newOrderGroup -> baseRepository.save(newOrderGroup))
			.map(newOrderGroup -> response(newOrderGroup))
			.orElseGet(() -> Header.ERROR("데이터 없음"));

	}

	@Override
	public Header<OrderGroupApiResponse> read(Long id) {
		return baseRepository.findById(id)
				.map(orderGroup -> response(orderGroup))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
		
		OrderGroupApiRequest body = request.getData();
		
		return baseRepository.findById(body.getId())
				.map(orderGroup -> {
					orderGroup.setTotalPrice(body.getTotalPrice())
						.setTotalQuantity(body.getTotalQuantity())
						.setStatus(body.getStatus())
						.setOrderType(body.getOrderType())
						.setRevAddress(body.getRevAddress())
						.setRevName(body.getRevName())
						.setUpdatedAt(LocalDateTime.now())
						.setUpdatedBy("ADMIN")
						.setArrivalDate(LocalDateTime.now());
					
					return orderGroup;
				})
				.map(orderGroup -> baseRepository.save(orderGroup))
				.map(orderGroup -> response(orderGroup))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	@SuppressWarnings({"rawtypes"})
	public Header delete(Long id) {
		return baseRepository.findById(id)
				.map(orderGroup -> {
					baseRepository.deleteById(id);
					return Header.OK();
				})
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@SuppressWarnings("unused")
	private Header<OrderGroupApiResponse> response(OrderGroup orderGroup) {
		OrderGroupApiResponse orderGroupApiResponse = OrderGroupApiResponse.builder()
												.id(orderGroup.getId())
												.userId(orderGroup.getUser().getId())
												.totalPrice(orderGroup.getTotalPrice())
												.totalQuantity(orderGroup.getTotalQuantity())
												.status(orderGroup.getStatus())
												.orderType(orderGroup.getOrderType())
												.revAddress(orderGroup.getRevAddress())
												.revName(orderGroup.getRevName())
												.paymentType(orderGroup.getPaymentType())
												.createdBy(orderGroup.getCreatedBy())
												.createdAt(orderGroup.getCreatedAt())
												.updatedBy(orderGroup.getUpdatedBy())
												.updatedAt(orderGroup.getUpdatedAt())
												.arrivalDate(orderGroup.getArrivalDate())
												.orderAt(orderGroup.getOrderAt())
												.build();
		
		return Header.OK(orderGroupApiResponse);
	}

	@Override
	public Header<List<OrderGroupApiResponse>> search(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
