package com.tampro.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.User;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.UserService;

@Controller
public class MainController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	
	@RequestMapping("/home")
	public String home(ModelMap map)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		// 6 san pham co view cao nhat trong tat ca san pham se hien ngoai trang
		map.addAttribute("viewproduct", productService.getProductViewMax());
		
		//4 san pham co view cao nhat cua tung danh muc
		map.addAttribute("appleproduct", productService.getProductViewApple());
		map.addAttribute("samsungproduct", productService.getProductViewSamsung());
		map.addAttribute("xiaomiproduct", productService.getProductViewXiaomi());
		
		return "home";
	}
	@RequestMapping(value="/login")
	public String login(ModelMap map,@RequestParam(name="err",required=false)String err)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		map.addAttribute("user", new User());
		if(err!=null)
		{
			map.addAttribute("mess", "Password hoac username sai ");
		}
		
		return "login";
	}
	@RequestMapping(value="/login-admin",method=RequestMethod.GET)
	public String login1(ModelMap map,@RequestParam(name="err",required=false)String err)
	{
		
		return "loginAdmin";
	}
	@RequestMapping(value="/register")
	public String register(ModelMap map,@RequestParam(name="err",required=false)String err)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		map.addAttribute("user", new User());
		
		return "register";
	}

	
	 @RequestMapping("/dang-xuat")
		public String dangxuat(HttpServletRequest request, HttpServletResponse response)
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // la nguoi dung 
			
			if(authentication !=null)
			{
				SecurityContextLogoutHandler contextLogoutHandler = new SecurityContextLogoutHandler();
				contextLogoutHandler.logout(request, response, authentication);
			}
			
			
			
			
			return "redirect:/home";
			
		}

	 @RequestMapping(value="/404")
		public String err()
		{
			
			return "err";
		}
	 

}
