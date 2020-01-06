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
import com.example.demo.repository.PartnerRepository;

@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

		ItemApiRequest body = request.getData();

		Item item = Item.builder()
					.status(body.getStatus())
					.name(body.getName())
					.title(body.getTitle())
					.content(body.getContent())
					.brandName(body.getBrandName())
					.createdBy("ADMIN USER")
					.registeredAt(LocalDateTime.now())
					.createdAt(LocalDateTime.now())
					.price(body.getPrice())
					.partner(partnerRepository.getOne(body.getId()))
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
		ItemApiRequest body = request.getData();
		
		Optional<Item> optional = itemRepository.findById(body.getId());
		
		return optional.map(item -> {
			item.setStatus(body.getStatus())
				.setName(body.getName())
				.setTitle(body.getTitle())
				.setContent(body.getContent())
				.setBrandName(body.getBrandName())
				.setUpdatedBy("ADMIN USER")
				.setUpdatedAt(LocalDateTime.now())
				.setPrice(body.getPrice())
				.setPartner(partnerRepository.getOne(body.getId()));
			
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
