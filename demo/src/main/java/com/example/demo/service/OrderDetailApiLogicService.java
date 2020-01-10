package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.entity.OrderDetail;
import com.example.demo.model.entity.OrderGroup;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.OrderDetailApiRequest;
import com.example.demo.model.network.response.OrderDetailApiResponse;
import com.example.demo.repository.OrderDetailRepository;

@Service
public class OrderDetailApiLogicService implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse>{

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {
		
		OrderDetailApiRequest body = request.getData();
		
		OrderGroup orderGroup = OrderGroup.builder().id(body.getOrderGroupId()).build();
		
		OrderDetail orderDetail = OrderDetail.builder()
								  .quantity(body.getQuantity())
								  .price(body.getPrice())
								  .status(body.getStatus())
								  .createdAt(LocalDateTime.now())
								  .createdBy("USER")
								  .orderGroup(orderGroup)
								  .build();
		
		OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
		
		return response(newOrderDetail);
	}

	@Override
	public Header<OrderDetailApiResponse> read(Long id) {
		return orderDetailRepository.findById(id)
				.map(orderDetail -> response(orderDetail))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
		
	}

	@Override
	public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
		
		OrderDetailApiRequest body = request.getData();
		
		return orderDetailRepository.findById(body.getId())
				.map(orderDetail -> {
					orderDetail.setQuantity(body.getQuantity())
							   .setPrice(body.getPrice())
							   .setStatus(body.getStatus())
							   .setUpdatedAt(LocalDateTime.now())
							   .setUpdatedBy("USER")
							   .setArrivalDate(LocalDateTime.now());
					return orderDetail;
				})
				.map(orderDetail -> orderDetailRepository.save(orderDetail))
				.map(orderDetail -> response(orderDetail))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	@SuppressWarnings({"rawtypes"})
	public Header delete(Long id) {
		return orderDetailRepository.findById(id)
				.map(orderDetail -> {
					orderDetailRepository.deleteById(id);
					return Header.OK();
				})
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@SuppressWarnings({"unused"})
	private Header<OrderDetailApiResponse> response(OrderDetail orderDetail) {
		
		OrderDetailApiResponse orderDetailApiResponse = OrderDetailApiResponse.builder()
														.id(orderDetail.getId())
														.quantity(orderDetail.getQuantity())
														.price(orderDetail.getPrice())
														.status(orderDetail.getStatus())
														.createdAt(orderDetail.getCreatedAt())
														.createdBy(orderDetail.getCreatedBy())
														.arrivalDate(orderDetail.getArrivalDate())
														.orderGroupId(orderDetail.getOrderGroup().getId())
														.updatedAt(orderDetail.getUpdatedAt())
														.updatedBy(orderDetail.getUpdatedBy())
														.build();
		
		return Header.OK(orderDetailApiResponse);
		
	}
	
}
