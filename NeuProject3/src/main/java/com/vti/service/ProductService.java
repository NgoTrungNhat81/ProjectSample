package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Product;

import com.vti.repository.IProductRepository;


@Service
public class ProductService implements IProductService{
	
	@Autowired
	private IProductRepository repository;

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProductByID(int id) {
		return repository.findById(id).get();
	}


	public void createProduct(Product product) {
		repository.save(product);
	}

	public void updateProduct(Product product) {
		repository.save(product);
	}

	public void deleteProduct(int id) {
		repository.deleteById(id);
	}
	

}
