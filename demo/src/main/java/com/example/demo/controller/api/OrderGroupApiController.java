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

@RestController
@RequestMapping("/api/ordergroup/")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupResponse>{

//	@Autowired
//	private O
	
	@Override
	@PostMapping("")
	public Header<OrderGroupResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("{id}")
	public Header<OrderGroupResponse> read(@PathVariable(name="id") Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("")
	public Header<OrderGroupResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable(name="id") Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
