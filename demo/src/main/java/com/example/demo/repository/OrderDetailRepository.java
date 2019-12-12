package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Item;

@Repository
public interface OrderDetailRepository extends JpaRepository<Item, Long>{

	
}
