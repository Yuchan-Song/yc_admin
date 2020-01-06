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
import com.example.demo.model.network.request.PartnerApiRequest;
import com.example.demo.model.network.response.PartnerApiResponse;
import com.example.demo.service.PartnerApiLogicService;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {
	
	@Autowired
	private PartnerApiLogicService partnerApiLogicService;

	@Override
	@PostMapping("")
	public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request) {
		return null;
	}

	@Override
	@GetMapping("{id}")
	public Header<PartnerApiResponse> read(@PathVariable(name="id") Long id) {
		return null;
	}

	@Override
	@PutMapping("")
	public Header<PartnerApiResponse> update(@RequestBody Header<PartnerApiRequest> request) {
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
