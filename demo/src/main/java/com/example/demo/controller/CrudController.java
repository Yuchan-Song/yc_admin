package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.controller.inf.CrudInterface;
import com.example.demo.model.network.Header;

import lombok.extern.slf4j.Slf4j;

/**
 * Code Refactoring을 위한 추상 클래스
 * @author Yuchan
 *
 */
@Slf4j
@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res, Entity> {
	
	@Autowired(required = false)
	protected CrudInterface<Req, Res, Entity> baseService;
	
	@GetMapping
	public Header<List<Res>> search(@PageableDefault(sort = "id", direction = Direction.DESC, page = 1, size = 20) Pageable pageable) {
		return baseService.search(pageable);
	}

	@Override
	@PostMapping("")
	public Header<Res> create(@RequestBody Header<Req> request) {
		log.info("{}", request);
		return baseService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<Res> read(@PathVariable(name="id") Long id) {
		log.info("read id : {}", id);
		return baseService.read(id);
	}

	@Override
	@PutMapping("")
	public Header<Res> update(@RequestBody Header<Req> request) {
		log.info("{}", request);
		return baseService.update(request);
	}

	@Override
	@DeleteMapping("{id}")
	@SuppressWarnings({"rawtypes"})
	public Header delete(@PathVariable(name="id") Long id) {
		log.info("read id : {}", id);
		return baseService.delete(id);
	}
	
	
	
}
