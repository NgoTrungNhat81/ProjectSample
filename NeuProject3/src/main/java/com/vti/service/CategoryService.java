package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Category;

import com.vti.repository.ICategoryRepository;


@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private ICategoryRepository repository;

	public List<Category> getAllCategories() {
		return repository.findAll();
	}

	public Category getCategoryByID(int id) {
		return repository.findById(id).get();
	}


	public void createCategory(Category category) {
		repository.save(category);
	}

	public void updateCategory(Category category) {
		repository.save(category);
	}

	public void deleteCategory(int id) {
		repository.deleteById(id);
	}

	


}
