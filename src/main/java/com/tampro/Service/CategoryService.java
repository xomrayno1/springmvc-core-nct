package com.tampro.Service;

import java.util.List;

import com.tampro.Model.Category;

public interface CategoryService {
	
public List<Category> getAllListCategory();
	
	public void addCategory(Category category);
	
	public void updateCategoryByid(Category category);
	
	public void deleteCategoryByid(int idcategory);

}
