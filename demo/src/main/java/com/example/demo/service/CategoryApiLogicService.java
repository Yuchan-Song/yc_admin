package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.CategoryApiRequest;
import com.example.demo.model.network.response.CategoryApiResponse;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse, Category>{
	
	@Override
	public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {
		CategoryApiRequest body = request.getData();
		
		Category category = Category.builder()
							.title(body.getTitle())
							.type(body.getType())
							.createdAt(LocalDateTime.now())
							.createdBy("ADMIN")
							.build();
		
		Category newCategory = baseRepository.save(category);
		
		return response(newCategory);
	}

	@Override
	public Header<CategoryApiResponse> read(Long id) {
		return baseRepository.findById(id)
				.map(category -> response(category))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
		
	}

	@Override
	public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
		CategoryApiRequest body = request.getData();
		
		return baseRepository.findById(body.getId())
				.map(category -> {
					category.setTitle(body.getTitle())
							.setUpdatedAt(LocalDateTime.now())
							.setUpdatedBy("ADMIN")
							.setType(body.getType());
					
					return category;
				})
				.map(category -> baseRepository.save(category))
				.map(category -> response(category))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	@SuppressWarnings({"rawtypes"})
	public Header delete(Long id) {
		return baseRepository.findById(id)
				.map(category -> {
					baseRepository.deleteById(id);
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

	@Override
	public Header<List<CategoryApiResponse>> search(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
