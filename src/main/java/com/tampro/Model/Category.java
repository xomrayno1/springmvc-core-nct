package com.tampro.Model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Category {
	private int idCategory;
	@NotEmpty
	private String nameCategory;
	private List<Product> listProduct;
	@NotEmpty
	private String urlCategory;
	
	
	public String getUrlCategory() {
		return urlCategory;
	}
	public void setUrlCategory(String urlCategory) {
		this.urlCategory = urlCategory;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	

}
