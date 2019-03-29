package com.tampro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.Category;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	/*
	 @RequestMapping("/danh-muc/{url}")
	public String Category(@PathVariable("url")String url,ModelMap map)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		for(Category cate : categoryService.getAllListCategory())
		{
	        if(cate.getUrlCategory().equals(url)) // neu url  = url tronglist thi ta co cate 
	        {
	         productService.getAllProductByIdCategory(cate.getIdCategory()); //  // lay ra tat ca san pham co cateid(url)
	         cate.setListProduct(productService.getProductByPage(cate.getIdCategory()));
	         map.addAttribute("product", cate.getListProduct());	        
	         return "product";
	        }
		}
		
		return "product";
	}*/
	
	
	
	@RequestMapping("/danh-muc/{loai}/{url}")
	public String Category2(@PathVariable("loai")String loai,@PathVariable("url")String url,ModelMap map,@RequestParam("page") int page)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		for(Category cate : categoryService.getAllListCategory())
		{
	        if(cate.getUrlCategory().equals(url)) // neu url  = url tronglist thi ta co cate 
	        {
	        	int countProduct = productService.countProductByIdCategoryAndLoai(cate.getIdCategory(), loai);
	        	int frist = 0;
	        	int last = 6;
	        	int countpage = 1;
	        	if(countProduct <= 6)
	        	{
	        		frist = 0;
	        		last = 6;
	        		
	        	}
	        	else
	        	{
	        		frist = (page-1) *6;
	        		last = 6;
	        		countpage = countProduct / 6;
	        		if(countProduct % 6 > 0)
	        		{
	        			countpage = countpage+1;
	        		}
	        		map.addAttribute("countpage", countpage);
	        	}
 	
	        	
	        	cate.setListProduct(productService.getProductByNavAndLoai(frist, last, cate.getIdCategory(), loai));
	        	map.addAttribute("product", cate.getListProduct());
	        	map.addAttribute("loai", loai);
	        	map.addAttribute("url", url);
	        	
	        	return "product";
	        }
		}
		
		return "product";
	}
	
	
	
	
	
	

	
}
