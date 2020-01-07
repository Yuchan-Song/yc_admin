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
import com.example.demo.model.network.request.OrderGroupApiRequest;
import com.example.demo.model.network.response.OrderGroupResponse;
import com.example.demo.service.OrderGroupApiLogicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/ordergroup/")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupResponse>{

	@Autowired
	private OrderGroupApiLogicService orderGroupApiLogicService;
	
	@Override
	@PostMapping("")
	public Header<OrderGroupResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
		log.info("{}", request);
		return orderGroupApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<OrderGroupResponse> read(@PathVariable(name="id") Long id) {
		log.info("id", id);
		return orderGroupApiLogicService.read(id);
	}

	@Override
	@PutMapping("")
	public Header<OrderGroupResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
		log.info("{}", request);
		return orderGroupApiLogicService.update(request);
	}

	@Override
	@DeleteMapping("{id}")
	@SuppressWarnings({"rawtypes"})
	public Header delete(@PathVariable(name="id") Long id) {
		log.info("id", id);
		return orderGroupApiLogicService.delete(id);
	}
	

}
