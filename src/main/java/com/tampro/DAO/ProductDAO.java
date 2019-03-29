package com.tampro.DAO;

import java.util.List;

import com.tampro.Model.Product;

public interface ProductDAO {
	
	public void addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public List<Product> getAllProductByIdCategory(int idCategory);
	
	public List<Product> getAllProductByIdCategoryAndLoai(int idCategory,String loai);
	
	public Product getProductbyId(int id);
	
	public void updateProduct(Product product);
	
	public void deleteProductById(int id);
	
	public List<Product> findProductByNameProductNav(String nameproduct,int frist, int last);
	
	public List<Product> ListfindProductByNameProduct(String nameproduct);
	
	public int countProductByIdCategory(int category);
	
	public int countProductByIdCategoryAndLoai(int idCategory,String loai );
	
	
	public List<Product> getProductByNav(int frist,int last,int idCategory);
	
	
	public List<Product> getProductByNavAndLoai(int frist,int last,int idCategory,String loai);
	
	public List<Product> getProductByPage(int idCategory);
	
	public Product getProductUrl(String url);
	
	public List<Product> getProductViewMax();
	
	public List<Product> getProductViewApple();
	
	public List<Product> getProductViewSamsung();
	
	public List<Product> getProductViewXiaomi();
	
	public List<Product> getProductViewSony();
	
	public List<Product> getProductViewNokia();
	
}
