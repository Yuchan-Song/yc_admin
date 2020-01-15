package com.example.demo.controller.api;

import com.example.demo.model.network.response.UserOrderInfoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.CrudController;
import com.example.demo.model.entity.User;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.UserApiRequest;
import com.example.demo.model.network.response.UserApiResponse;
import com.example.demo.service.UserApiLogicService;

@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {
	
	@Autowired
	private UserApiLogicService userApiLogicService;
	
	@GetMapping("/{id}/orderinfo")
	public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable(name="id") Long id) {
		return userApiLogicService.orderInfo(id);
	}

}
