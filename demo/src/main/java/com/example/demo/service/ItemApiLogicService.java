package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Item;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.ItemApiRequest;
import com.example.demo.model.network.response.ItemApiResponse;
import com.example.demo.repository.PartnerRepository;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item> {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
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
		
		Item newItem = baseRepository.save(item);
		
		return this.response(newItem);

	}

	@Override
	public Header<ItemApiResponse> read(Long id) {
		Optional<Item> optional = baseRepository.findById(id);
		
		return optional.map(item -> response(item))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {

		return Optional.ofNullable(request.getData())
				.map(body ->{
					return baseRepository.findById(body.getId());
				})
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(item -> {

					ItemApiRequest body = request.getData();
					item.setStatus(body.getStatus())
							.setTitle(body.getTitle())
							.setContent(body.getContent())
							.setName(body.getName())
							.setPrice(body.getPrice())
							.setBrandName(body.getBrandName())
							.setPartner(partnerRepository.getOne(body.getPartnerId()))
							.setStatus(body.getStatus())
							.setRegisteredAt(body.getRegisteredAt())
							.setUnregisteredAt(body.getUnregisteredAt())
					;
					return item;

				})
		.map(item -> baseRepository.save(item))
		.map(item -> response(item))
		.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@SuppressWarnings({"rawtypes"})
	@Override
	public Header delete(Long id) {
		Optional<Item> optional = baseRepository.findById(id);
		return optional.map(item -> {
			baseRepository.deleteById(id);
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

	@Override
	public Header<List<ItemApiResponse>> search(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
