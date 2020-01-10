package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.entity.Category;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.CategoryApiRequest;
import com.example.demo.model.network.response.CategoryApiResponse;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryApiLogicService implements CrudInterface<CategoryApiRequest, CategoryApiResponse>{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {
		CategoryApiRequest body = request.getData();
		
		Category category = Category.builder()
							.title(body.getTitle())
							.type(body.getType())
							.createdAt(LocalDateTime.now())
							.createdBy("ADMIN")
							.build();
		
		Category newCategory = categoryRepository.save(category);
		
		return response(newCategory);
	}

	@Override
	public Header<CategoryApiResponse> read(Long id) {
		return categoryRepository.findById(id)
				.map(category -> response(category))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
		
	}

	@Override
	public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
		CategoryApiRequest body = request.getData();
		
		return categoryRepository.findById(body.getId())
				.map(category -> {
					category.setTitle(body.getTitle())
							.setUpdatedAt(LocalDateTime.now())
							.setUpdatedBy("ADMIN")
							.setType(body.getType());
					
					return category;
				})
				.map(category -> categoryRepository.save(category))
				.map(category -> response(category))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	@SuppressWarnings({"rawtypes"})
	public Header delete(Long id) {
		return categoryRepository.findById(id)
				.map(category -> {
					categoryRepository.deleteById(id);
					return Header.OK();
				})
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	
	private Header<CategoryApiResponse> response(Category category) {
		CategoryApiResponse categoryApiResponse = CategoryApiResponse.builder()
												.id(category.getId())
												.title(category.getTitle())
												.type(category.getType())
												.createdAt(category.getCreatedAt())
												.createdBy(category.getCreatedBy())
												.updatedAt(category.getUpdatedAt())
												.updatedBy(category.getUpdatedBy())
												.build();
		
		return Header.OK(categoryApiResponse);
	}
	
}
