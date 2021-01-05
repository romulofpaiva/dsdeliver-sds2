package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll( ) {
		return repository.findOrdersWithProducts().stream().map( order -> new OrderDTO( order ) ).collect( Collectors.toList() );
	}
}
