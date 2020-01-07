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
import com.example.demo.model.network.request.AdminUserApiRequest;
import com.example.demo.model.network.response.AdminUserApiResponse;
import com.example.demo.service.AdminUserApiLogicService;

@RestController
@RequestMapping("/api/adminuser/")
public class AdminUserApiController implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse>{
	
	@Autowired
	private AdminUserApiLogicService adminUserApiLogicService;

	@Override
	@PostMapping("")
	public Header<AdminUserApiResponse> create(@RequestBody Header<AdminUserApiRequest> request) {
		return adminUserApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<AdminUserApiResponse> read(@PathVariable(name="id") Long id) {
		return adminUserApiLogicService.read(id);
	}

	@Override
	@PutMapping("")
	public Header<AdminUserApiResponse> update(@RequestBody Header<AdminUserApiRequest> request) {
		return adminUserApiLogicService.update(request);
	}

	@Override
	@DeleteMapping("{id}")
	@SuppressWarnings({"rawtypes"})
	public Header delete(Long id) {
		return adminUserApiLogicService.delete(id);
	}

}
