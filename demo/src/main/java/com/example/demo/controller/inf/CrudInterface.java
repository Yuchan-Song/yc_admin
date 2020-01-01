package com.example.demo.controller.inf;

import com.example.demo.model.network.Header;

@SuppressWarnings("rawtypes")
public interface CrudInterface {
	
	Header create();
	
	Header read(Long id);
	
	Header update();

	Header delete(Long id);
}
