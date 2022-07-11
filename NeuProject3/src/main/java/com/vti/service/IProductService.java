package com.vti.service;

import java.util.List;

import com.vti.entity.Product;


public interface IProductService {
	public List<Product> getAllProducts();

	public Product getProductByID(int id);
//

//
	public void createProduct(Product product);
//
	public void updateProduct(Product product);
//
	public void deleteProduct(int id);
	
	
}
