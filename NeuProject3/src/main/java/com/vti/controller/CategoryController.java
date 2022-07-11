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

import com.vti.dto.CategoryDTO;

import com.vti.entity.Category;

import com.vti.service.ICategoryService;


@RestController
@RequestMapping(value = "api/v1/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	@Autowired
	private ICategoryService service;

	@GetMapping()
	public ResponseEntity<?> getAllCategorys() {
		//get data
		List<Category> entities = service.getAllCategories();
//		
		
		
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		
		
		//convert entity to dto
		for (Category entity : entities) {
			CategoryDTO dto = new CategoryDTO();
			dto.setId(entity.getId());
			dto.setCategoryname(entity.getCategoryname());
			dto.setDescription(entity.getDescription());		
			dtos.add(dto);		
		}
	
		return new ResponseEntity<List<CategoryDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public CategoryDTO getCategoryByID(@PathVariable(name = "id") int id) {
		Category category = service.getCategoryByID(id);
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setCategoryname(category.getCategoryname());
		dto.setDescription(category.getDescription());
		return dto;
	}
	
	@PostMapping()
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO dto) {
		service.createCategory(dto.toEntity());			
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable(name = "id") int id, @RequestBody CategoryDTO dto) {		
		Category category  = dto.toEntity();
		category.setId(id);
		service.updateCategory(category);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") int id) {
		service.deleteCategory(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	
	
	
	
}
