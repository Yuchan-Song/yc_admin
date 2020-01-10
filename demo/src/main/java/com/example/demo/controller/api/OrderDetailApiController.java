package com.example.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.OrderDetailApiRequest;
import com.example.demo.model.network.response.OrderDetailApiResponse;
import com.example.demo.service.OrderDetailApiLogicService;

@RestController
@RequestMapping("/api/orderdetail/")
public class OrderDetailApiController implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse> {

	@Autowired
	private OrderDetailApiLogicService orderDetailApiLogicService;
	
	@Override
	@PostMapping("")
	public Header<OrderDetailApiResponse> create(@RequestBody Header<OrderDetailApiRequest> request) {
		return orderDetailApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<OrderDetailApiResponse> read(@PathVariable(name="id") Long id) {
		return orderDetailApiLogicService.read(id);
	}

	@Override
	@PutMapping("")
	public Header<OrderDetailApiResponse> update(@RequestBody Header<OrderDetailApiRequest> request) {
		return orderDetailApiLogicService.update(request);
	}

	@Override
	@DeleteMapping("{id}")
	@SuppressWarnings({"rawtypes"})
	public Header delete(@PathVariable(name="id") Long id) {
		return orderDetailApiLogicService.delete(id);
	}

}
