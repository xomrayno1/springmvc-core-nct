package com.tampro.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.Product;
import com.tampro.Model.User;
import com.tampro.Model.Wish;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.UserService;
import com.tampro.Service.WishService;

@Controller
@RequestMapping("/user")
public class WishController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	WishService wishService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/add-wish")
	public String addWish(ModelMap map ,@RequestParam("idProduct")int idProduct)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // la nguoi dung 
		User user  = userService.getUserByUsername(authentication.getName());	
		
		boolean kt= true;
		if(wishService.getAllWishByIdUser(user.getIdUser()).size() >= 5 )
		{
			return "redirect:/user/wish";	
		}
		
		
		for(Wish wish : wishService.getAllWishByIdUser(user.getIdUser()))
		{
			if(wish.getIdproduct()==idProduct)
			{
				kt = false;
				break;
			}
			
		}
		if(kt)
		{
			Wish wish = new Wish();
			
			wish.setIdUser(user.getIdUser());
			wish.setIdproduct(idProduct);	
			wishService.addWish(wish);
		}
		
		return "redirect:/user/wish";		
	}
	@RequestMapping("/wish")
	public String homeWish(ModelMap map)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // la nguoi dung 
		User user  = userService.getUserByUsername(authentication.getName());
		List<Product> listWish = new ArrayList<Product>();
		
		for(Wish wish : wishService.getAllWishByIdUser(user.getIdUser()))
		{
		  Product product = 	productService.getProductbyId(wish.getIdproduct());
		  listWish.add(product);
		}
		
		map.addAttribute("wishlist", listWish);
		
		
		
		
		return "wish";		
	}
	@RequestMapping("/drop-wish")
	public String dropWish(ModelMap map,@RequestParam("idProduct")int idProduct)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		
		wishService.DeleteWishById(idProduct);
		
		return  "redirect:/user/wish";	
	}

}
