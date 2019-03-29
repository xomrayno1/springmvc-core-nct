package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.DAO.ProductDAO;
import com.tampro.Model.Product;
import com.tampro.Service.ProductService;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService{

	@Autowired
	ProductDAO productDAO;
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.addProduct(product);
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDAO.getAllProduct();
	}

	public List<Product> getAllProductByIdCategory(int idCategory) {
		// TODO Auto-generated method stub
		return productDAO.getAllProductByIdCategory(idCategory);
	}

	public Product getProductbyId(int id) {
		// TODO Auto-generated method stub
		return productDAO.getProductbyId(id);
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.updateProduct(product);
	}

	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productDAO.deleteProductById(id);
	}

	public List<Product> findProductByNameProduct(String nameproduct,int frist, int last) {
		// TODO Auto-generated method stub
		return productDAO.findProductByNameProductNav(nameproduct, frist, last);
	}

	public List<Product> getAllProductByIdCategoryAndLoai(int idCategory, String loai) {
		// TODO Auto-generated method stub
		return productDAO.getAllProductByIdCategoryAndLoai(idCategory, loai);
	}

	public int countProductByIdCategory(int category) {
		// TODO Auto-generated method stub
		return productDAO.countProductByIdCategory(category);
	}

	public int countProductByIdCategoryAndLoai(int idCategory, String loai) {
		// TODO Auto-generated method stub
		return productDAO.countProductByIdCategoryAndLoai(idCategory, loai);
	}

	public List<Product> getProductByNav(int frist, int last, int idCategory) {
		// TODO Auto-generated method stub
		return productDAO.getProductByNav(frist, last, idCategory);
	}

	public List<Product> getProductByNavAndLoai(int frist, int last, int idCategory, String loai) {
		// TODO Auto-generated method stub
		return productDAO.getProductByNavAndLoai(frist, last, idCategory, loai);
	}

	public List<Product> getProductByPage(int idCategory) {
		// TODO Auto-generated method stub
		return productDAO.getProductByPage(idCategory);
	}

	public Product getProductUrl(String url) {
		// TODO Auto-generated method stub
		return productDAO.getProductUrl(url);
	}

	public List<Product> getProductViewMax() {
		// TODO Auto-generated method stub
		return productDAO.getProductViewMax();
	}

	public List<Product> getProductViewApple() {
		// TODO Auto-generated method stub
		return productDAO.getProductViewApple();
	}

	public List<Product> getProductViewSamsung() {
		// TODO Auto-generated method stub
		return productDAO.getProductViewSamsung();
	}

	public List<Product> getProductViewXiaomi() {
		// TODO Auto-generated method stub
		return productDAO.getProductViewXiaomi();
	}

	public List<Product> getProductViewSony() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductViewNokia() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> ListfindProductByNameProduct(String nameproduct) {
		// TODO Auto-generated method stub
		return productDAO.ListfindProductByNameProduct(nameproduct);
	}

}
