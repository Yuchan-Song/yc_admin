package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.entity.User;
import com.example.demo.model.enumclass.UserStatus;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.UserApiRequest;
import com.example.demo.model.network.response.UserApiResponse;
import com.example.demo.repository.UserRepository;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {
	
	@Autowired
	private UserRepository userRepository;

	// 1. get request data
	// 2. create User
	// 3. return UserApiResponse
	@Override
	public Header<UserApiResponse> create(Header<UserApiRequest> request) {
		
		// 1. get request data
		UserApiRequest userApiRequest = request.getData();
		
		// 2. create User
		User user = User.builder()
					.account(userApiRequest.getAccount())
					.password(userApiRequest.getPassword())
					.status(UserStatus.REGISTERED)
					.phoneNumber(userApiRequest.getPhoneNumber())
					.email(userApiRequest.getEmail())
					.registeredAt(LocalDateTime.now())
					.build();

		User newUser = userRepository.save(user);
	
		// 3. return UserApiResponse
		return this.response(newUser);
	}

	@Override
	public Header<UserApiResponse> read(Long id) {

		// 1. id -> response getOne, getById
		Optional<User> optional = userRepository.findById(id);
		
		// 2. return UserApiResponse
		return optional.map(user -> response(user))
				.orElseGet(() -> Header.ERROR("데이터 없음"));
		
	}

	@Override
	public Header<UserApiResponse> update(Header<UserApiRequest> request) {
		// 1. get data
		UserApiRequest userApiRequest = request.getData();
		
		// 2. user findbyId
		Optional<User> optional = userRepository.findById(userApiRequest.getId());
		
		// 3. update & create response
		return optional.map(user -> {
			user.setAccount(userApiRequest.getAccount())
				.setPassword(userApiRequest.getPassword())
				.setPhoneNumber(userApiRequest.getPhoneNumber())
				.setStatus(userApiRequest.getStatus())
				.setEmail(userApiRequest.getEmail())
				.setRegisteredAt(userApiRequest.getRegisteredAt())
				.setUnregisteredAt(userApiRequest.getUnregisteredAt());
			
			return user;
		})
		.map(user -> userRepository.save(user))		// update
		.map(user -> response(user))				// create response
		.orElseGet(() -> Header.ERROR("데이터 없음"));
		
	}

	@SuppressWarnings({"rawtypes"})
	@Override
	public Header delete(Long id) {
		// 1. id -> response getOne, getById
		Optional<User> optional = userRepository.findById(id);
		
		// 2. delete
		return optional.map(user -> {
			userRepository.delete(user); // delete	
			return Header.OK();
		})
		.orElseGet(() -> Header.ERROR("데이터 없음"));
	}
	
	// user 를 UserApiResponse로 만들어서 return
	private Header<UserApiResponse> response(User user) {
		
		// User -> UserApiResponse
		UserApiResponse userApiResponse = UserApiResponse.builder()
										.id(user.getId())
										.account(user.getAccount())			// TODO :: 암호화
										.password(user.getPassword())
										.email(user.getEmail())
										.phoneNumber(user.getPhoneNumber())
										.status(user.getStatus())
										.registeredAt(user.getRegisteredAt())
										.unregisteredAt(user.getUnregisteredAt())
										.build();
		
		// Header + data return
		return Header.OK(userApiResponse);
	}

}
