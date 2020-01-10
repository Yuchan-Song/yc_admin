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
import com.example.demo.model.network.request.CategoryApiRequest;
import com.example.demo.model.network.response.CategoryApiResponse;
import com.example.demo.service.CategoryApiLogicService;

@RestController
@RequestMapping("/api/category/")
public class CategoryApiController implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {
	
	@Autowired
	private CategoryApiLogicService categoryApiLogicService;

	@Override
	@PostMapping("")
	public Header<CategoryApiResponse> create(@RequestBody Header<CategoryApiRequest> request) {
		return categoryApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<CategoryApiResponse> read(@PathVariable(name="id") Long id) {
		return categoryApiLogicService.read(id);
	}

	@Override
	@PutMapping("")
	public Header<CategoryApiResponse> update(@RequestBody Header<CategoryApiRequest> request) {
		return categoryApiLogicService.update(request);
	}

	@Override
	@SuppressWarnings({"rawtypes"})
	@DeleteMapping("{id}")
	public Header delete(@PathVariable(name="id") Long id) {
		return categoryApiLogicService.delete(id);
	}

}
