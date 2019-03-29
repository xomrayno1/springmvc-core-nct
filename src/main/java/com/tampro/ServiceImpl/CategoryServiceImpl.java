package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.CategoryDAO;
import com.tampro.Model.Category;
import com.tampro.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO categoryDAO;
	
	
	public List<Category> getAllListCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getAllListCategory();
	}

	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.addCategory(category);
	}

	public void updateCategoryByid(Category category) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCategoryByid(int idcategory) {
		// TODO Auto-generated method stub
		categoryDAO.deleteCategoryByid(idcategory);
	}

}
