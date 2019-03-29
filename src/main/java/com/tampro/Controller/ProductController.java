package com.tampro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.Product;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;

@Controller
public class ProductController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	    @RequestMapping("/{url}") //single
		public String single(ModelMap map,@PathVariable("url") String url)
		{
			map.addAttribute("category", categoryService.getAllListCategory());
			
			
			Product product = productService.getProductUrl(url);// lay ra product urrl
			int view  = product.getViewProduct()+1;// lay so view cua product do  + them 1 
			product.setViewProduct(view); // set
			productService.updateProduct(product);
			
			map.addAttribute("product", productService.getProductUrl(url));
			
			switch(product.getIdCategory()) // tag
			{
			case 1 :
				map.addAttribute("tagproduct", productService.getProductViewSamsung());
				break;
			case 2 :
				map.addAttribute("tagproduct", productService.getProductViewSony());
				break;
			case 3 :
				map.addAttribute("tagproduct", productService.getProductViewNokia());
				break;
			case 4 :
				map.addAttribute("tagproduct", productService.getProductViewApple());
				break;
			case 5 :
				map.addAttribute("tagproduct", productService.getProductViewXiaomi());
				break;
			}
	
			return "single";
		}
	    @RequestMapping("/tim-kiem/{page}") 
		public String timkiem(ModelMap map,@RequestParam("name") String name,@PathVariable("page") int page)
		{
			map.addAttribute("category", categoryService.getAllListCategory());
			int size = productService.ListfindProductByNameProduct(name).size();
			int frist = 0;
        	int last = 0;
        	int countpage = 1;
			if(size  <=6)
			{
				 frist = 0;
	        	 last = 6;
			}
			else
			{
				frist = (page-1) *6;
        		last = 6;
        		countpage = size / 6;
        		if(size % 6 > 0)
        		{
        			countpage = countpage+1;
        		}
        		map.addAttribute("countpage", countpage);
			}
			map.addAttribute("nametimkiem", name);
			map.addAttribute("product", productService.findProductByNameProduct(name, frist, last));
			
			
	
			return "seachproduct";
		}
}
