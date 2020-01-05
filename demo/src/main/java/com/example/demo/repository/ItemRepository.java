package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Item;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.ItemApiRequest;
import com.example.demo.model.network.response.ItemApiResponse;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	

}
