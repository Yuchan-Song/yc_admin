package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.OrderDetail;
import com.example.demo.model.entity.OrderGroup;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.OrderDetailApiRequest;
import com.example.demo.model.network.response.OrderDetailApiResponse;

@Service
public class OrderDetailApiLogicService extends BaseService<OrderDetailApiRequest, OrderDetailApiResponse, OrderDetail>{
	
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
		
		OrderDetail newOrderDetail = baseRepository.save(orderDetail);
		
		return response(newOrderDetail);
	}

	@Override
	public Header<OrderDetailApiResponse> read(Long id) {
		return baseRepository.findById(id)
				.map(orderDetail -> response(orderDetail))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
		
	}

	@Override
	public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
		
		OrderDetailApiRequest body = request.getData();
		
		return baseRepository.findById(body.getId())
				.map(orderDetail -> {
					orderDetail.setQuantity(body.getQuantity())
							   .setPrice(body.getPrice())
							   .setStatus(body.getStatus())
							   .setUpdatedAt(LocalDateTime.now())
							   .setUpdatedBy("USER")
							   .setArrivalDate(LocalDateTime.now());
					return orderDetail;
				})
				.map(orderDetail -> baseRepository.save(orderDetail))
				.map(orderDetail -> response(orderDetail))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	@SuppressWarnings({"rawtypes"})
	public Header delete(Long id) {
		return baseRepository.findById(id)
				.map(orderDetail -> {
					baseRepository.deleteById(id);
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

	@Override
	public Header<List<OrderDetailApiResponse>> search(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
