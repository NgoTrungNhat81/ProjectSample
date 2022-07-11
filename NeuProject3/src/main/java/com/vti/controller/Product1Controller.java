package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.ProductDTO;

import com.vti.entity.Product;
import com.vti.service.IProduct1Service;


@RestController
@RequestMapping(value = "api/v1/products1")
@CrossOrigin(origins = "*")
public class Product1Controller {
	
	@Autowired
	private IProduct1Service service;

	@GetMapping()
	public ResponseEntity<?> getAllProducts() {
		//get data
		List<Product> entities = service.getAllProducts();
//		
		
		
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		
		
		//convert entity to dto
		for (Product entity : entities) {
			ProductDTO dto = new ProductDTO();
			dto.setId(entity.getId());
			dto.setCategory(entity.getCategory());;
			dto.setProductname(entity.getProductname());;
			dto.setDescription(entity.getDescription());
			dto.setImage(entity.getImage());
			dto.setSellprice(entity.getSellprice());
			dtos.add(dto);		
		}
	
	
		return new ResponseEntity<List<ProductDTO>>(dtos, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ProductDTO getProductByID(@PathVariable(name = "id") short id) {
		Product product = service.getProductByID(id);
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setCategory(product.getCategory());
		dto.setProductname(product.getProductname());
		dto.setDescription(product.getDescription());
		dto.setImage(product.getImage());
		dto.setSellprice(product.getSellprice());
		return dto;
	}
	
	@PostMapping()
	public ResponseEntity<?> createProduct(@RequestBody ProductDTO dto) {
		service.createProduct(dto.toEntity());			
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") int id, @RequestBody ProductDTO dto) {		
		Product product  = dto.toEntity();
		product.setId(id);
		service.updateProduct(product);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") short id) {
		service.deleteProduct(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}


}
