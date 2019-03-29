package com.tampro.Model;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int idProduct;
	@NotEmpty
	private String nameProduct; // ten san pham
	
	private int discountProduct; // sale san pham
	
	private int priceProduct; // gia san pham 
	private String dateCreatedProduct; // thoi gian dang san pham
	private int viewProduct; // so luot xem san pham
	private String imagesProduct; // anh san pham
	
	private int quantityProduct; // so luong san pham
	
	private int idCategory;
	@NotEmpty
	private String urlProduct;
	
	private int ramProduct;
	
	private String loaiProduct;

	private MultipartFile multipartResolver;
	
	
	
	
	
	public MultipartFile getMultipartResolver() {
		return multipartResolver;
	}
	public void setMultipartResolver(MultipartFile multipartResolver) {
		this.multipartResolver = multipartResolver;
	}
	public String getLoaiProduct() {
		return loaiProduct;
	}
	public void setLoaiProduct(String loaiProduct) {
		this.loaiProduct = loaiProduct;
	}
	public String getUrlProduct() {
		return urlProduct;
	}
	public void setUrlProduct(String urlProduct) {
		this.urlProduct = urlProduct;
	}
	public int getRamProduct() {
		return ramProduct;
	}
	public void setRamProduct(int ramProduct) {
		this.ramProduct = ramProduct;
	}
	
	public int getIdProduct() {
		return idProduct;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getDiscountProduct() {
		return discountProduct;
	}
	public void setDiscountProduct(int discountProduct) {
		this.discountProduct = discountProduct;
	}
	public int getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	public String getDateCreatedProduct() {
		return dateCreatedProduct;
	}
	public void setDateCreatedProduct(String dateCreatedProduct) {
		this.dateCreatedProduct = dateCreatedProduct;
	}
	public int getViewProduct() {
		return viewProduct;
	}
	public void setViewProduct(int viewProduct) {
		this.viewProduct = viewProduct;
	}
	public String getImagesProduct() {
		return imagesProduct;
	}
	public void setImagesProduct(String imagesProduct) {
		this.imagesProduct = imagesProduct;
	}
	public int getQuantityProduct() {
		return quantityProduct;
	}
	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}
	
	
	

}
