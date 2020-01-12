package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Partner;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.PartnerApiRequest;
import com.example.demo.model.network.response.PartnerApiResponse;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiResponse, Partner>{

	@Override
	public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
		
		PartnerApiRequest body = request.getData();
		
		Partner partner = Partner.builder()
								.address(body.getAddress())
								.businessNumber(body.getBusinessNumber())
								.callCenter(body.getCallCenter())
								.ceoName(body.getCeoName())
								.name(body.getName())
								.status(body.getStatus())
								.partnerNumber(body.getPartnerNumber())
								.createdBy("ADMIN")
								.createdAt(LocalDateTime.now())
								.registeredAt(LocalDateTime.now())
								.build();

		Partner newPartner = baseRepository.save(partner);
		
		return response(newPartner);
	}

	@Override
	public Header<PartnerApiResponse> read(Long id) {
		return baseRepository.findById(id)
				.map(partner -> response(partner))
				.orElseGet(() -> Header.ERROR("데이터가 없음"));
	}

	@Override
	public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
		PartnerApiRequest body = request.getData();
		
		Optional<Partner> optional = baseRepository.findById(body.getId());
		
		return optional.map(partner -> {
			partner.setAddress(body.getAddress())
				.setBusinessNumber(body.getBusinessNumber())
				.setCallCenter(body.getCallCenter())
				.setCeoName(body.getCeoName())
				.setName(body.getName())
				.setStatus(body.getStatus())
				.setPartnerNumber(body.getPartnerNumber())
				.setUpdatedAt(LocalDateTime.now())
				.setUpdatedBy("ADMIN");
			
				return partner;
		})
		.map(partner -> baseRepository.save(partner))
		.map(partner -> response(partner))
		.orElseGet(() -> Header.ERROR("데이터가 없음"));
	}

	@Override
	@SuppressWarnings({"rawtypes"})
	public Header delete(Long id) {
		Optional<Partner> optional = baseRepository.findById(id);
		
		return  optional.map(partner -> {
					baseRepository.deleteById(id);
					return Header.OK();
				})
				.orElseGet(() -> Header.ERROR("데이터가 없음"));
	}
	
	
	@SuppressWarnings({"unused"})
	private Header<PartnerApiResponse> response(Partner partner) {
		PartnerApiResponse partnerApiResponse = PartnerApiResponse.builder()
												.id(partner.getId())
												.address(partner.getAddress())
												.businessNumber(partner.getBusinessNumber())
												.callCenter(partner.getCallCenter())
												.ceoName(partner.getCeoName())
												.name(partner.getName())
												.status(partner.getStatus())
												.partnerNumber(partner.getPartnerNumber())
												.createdBy(partner.getCreatedBy())
												.createdAt(partner.getCreatedAt())
												.updatedBy(partner.getUpdatedBy())
												.updatedAt(partner.getUpdatedAt())
												.registeredAt(partner.getRegisteredAt())
												.unregisteredAt(partner.getUnregisteredAt())
												.build();
		
		return Header.OK(partnerApiResponse);
	}

	@Override
	public Header<List<PartnerApiResponse>> search(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
