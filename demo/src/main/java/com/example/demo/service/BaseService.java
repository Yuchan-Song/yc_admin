package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.controller.inf.CrudInterface;

@Component
public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res, Entity>{

	// JpaRepository<Entity, Long> 형태로 인터페이스를 상속 받고 있는 Repository를 주입 시켜준다
	@Autowired(required = false)
	protected JpaRepository<Entity, Long> baseRepository;

}
