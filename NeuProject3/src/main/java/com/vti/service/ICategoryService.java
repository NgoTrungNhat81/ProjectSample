package com.vti.service;

import java.util.List;

import com.vti.entity.Category;



public interface ICategoryService {
	
	 List<Category> getAllCategories();

	 Category getCategoryByID(int id);
//

//
	 void createCategory(Category category);
//
	 void updateCategory(Category category);
//
	void deleteCategory(int id);

}
