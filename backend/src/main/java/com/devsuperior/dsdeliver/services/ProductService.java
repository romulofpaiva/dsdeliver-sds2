package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll( ) {
		return repository.findAllByOrderByNameAsc().stream().map( product -> new ProductDTO( product ) ).collect( Collectors.toList() );
	}
}
