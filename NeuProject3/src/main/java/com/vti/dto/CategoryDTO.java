package com.vti.dto;

import com.vti.entity.Category;

public class CategoryDTO {
	private int id;
	private String categoryname;
	private String description;
	
	
	public CategoryDTO() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category toEntity() {
		return new Category(id,categoryname,description);
	}
	
	
}
