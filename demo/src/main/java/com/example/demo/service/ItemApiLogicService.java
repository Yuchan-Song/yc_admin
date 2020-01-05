package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.entity.Item;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.ItemApiRequest;
import com.example.demo.model.network.response.ItemApiResponse;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

		ItemApiRequest itemApiRequest = request.getData();

		Item item = Item.builder()
					.status(itemApiRequest.getStatus())
					.name(itemApiRequest.getName())
					.title(itemApiRequest.getTitle())
					.content(itemApiRequest.getContent())
					.brandName(itemApiRequest.getBrandName())
					.createdBy("ADMIN USER")
					.registeredAt(LocalDateTime.now())
					.createdAt(LocalDateTime.now())
					.price(itemApiRequest.getPrice())
					.build();
		
		Item newItem = itemRepository.save(item);
		
		return this.response(newItem);

	}

	@Override
	public Header<ItemApiResponse> read(Long id) {
		Optional<Item> optional = itemRepository.findById(id);
		
		return optional.map(item -> response(item))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
		ItemApiRequest itemApiRequest = request.getData();
		
		Optional<Item> optional = itemRepository.findById(itemApiRequest.getId());
		
		return optional.map(item -> {
			item.setStatus(itemApiRequest.getStatus())
				.setName(itemApiRequest.getName())
				.setTitle(itemApiRequest.getTitle())
				.setContent(itemApiRequest.getContent())
				.setBrandName(itemApiRequest.getBrandName())
				.setUpdatedBy("ADMIN USER")
				.setUpdatedAt(LocalDateTime.now())
				.setPrice(itemApiRequest.getPrice());
			
			return item;
		})
		.map(item -> itemRepository.save(item))
		.map(item -> response(item))
		.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public Header delete(Long id) {
		Optional<Item> optional = itemRepository.findById(id);
		return optional.map(item -> {
			itemRepository.deleteById(id);
			return Header.OK();
		})
		.orElseGet(() -> Header.ERROR("데이터 없음"));
	}
	
	public Header<ItemApiResponse> response(Item item) {
		
		ItemApiResponse itemApiResponse = ItemApiResponse.builder()
										  .id(item.getId())
										  .price(item.getPrice())
										  .status(item.getStatus())
										  .name(item.getName())
										  .title(item.getTitle())
										  .content(item.getContent())
										  .brandName(item.getBrandName())
										  .createdBy(item.getCreatedBy())
										  .updatedBy(item.getUpdatedBy())
										  .registeredAt(item.getRegisteredAt())
										  .unregisteredAt(item.getUnregisteredAt())
										  .createdAt(item.getCreatedAt())
										  .updatedAt(item.getUpdatedAt())
										  .build();
		
		return Header.OK(itemApiResponse);
	}

}
