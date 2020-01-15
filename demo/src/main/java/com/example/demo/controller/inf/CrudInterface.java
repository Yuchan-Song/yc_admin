package com.example.demo.controller.inf;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.model.network.Header;

public interface CrudInterface<Req, Res, Entity> {
	
	Header<Res> create(Header<Req> request);
	
	Header<Res> read(Long id);
	
	Header<Res> update(Header<Req> request);

	@SuppressWarnings("rawtypes")
	Header delete(Long id);

	Header<List<Res>> search(Pageable pageable);
}
