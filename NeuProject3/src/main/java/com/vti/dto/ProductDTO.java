package com.vti.dto;


import com.vti.entity.Category;
import com.vti.entity.Product;


public class ProductDTO {
	private int id;
	private Category category;
	private String productname;
	private String description;
	private String image;
	private int sellprice;
	
	
	public ProductDTO() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getSellprice() {
		return sellprice;
	}


	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}
	
	public Product toEntity() {
		return new Product(id,category,productname,description,image,sellprice);
	}
}
