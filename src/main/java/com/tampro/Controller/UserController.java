package com.tampro.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.User;
import com.tampro.Service.CategoryService;
import com.tampro.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/account")
	public String accountUser(ModelMap map,HttpServletRequest request, HttpServletResponse response)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // la nguoi dung 
		
		User user  = userService.getUserByUsername(authentication.getName());
		map.addAttribute("user", user);
		
		return "account";
	}
	@RequestMapping("/update")
	public String updateUser(ModelMap map,@RequestParam("diachi") String diachi,@RequestParam("sdt") String sdt )
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // la nguoi dung 
		
		User user  = userService.getUserByUsername(authentication.getName()); 
		user.setAddress(diachi);
		user.setSdt(sdt);
		userService.updateUserByid(user);
		
		
		
		return "redirect:/user/account";
	}
	@RequestMapping("/update-mat-khau")
	public String updatepassword(ModelMap map)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		 
		
		return "updatepassword";
	}
	@RequestMapping("/update-password")
	public String updatepassword(ModelMap map,@RequestParam("newpassword") String newpass,@RequestParam("repnewpassword") String repnewpass)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		if(newpass.equals(repnewpass))
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // la nguoi dung 
			User user  = userService.getUserByUsername(authentication.getName()); 
			user.setPassword(newpass);
			userService.updateUserByid(user);
			
			map.addAttribute("mess", "doi mat khau thanh cong");
			
		}
		else
		{
			map.addAttribute("mess", "doi mat khau khong thanh cong");
		}
		
		

		return "updatepassword";
	}
	@RequestMapping(value="/them-user")
	public String login(ModelMap map,@ModelAttribute("user") @Valid User us,BindingResult bindingResult)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		
		if(bindingResult.hasErrors())
		{
			
			return "register";
		}
		User user = userService.getUserByUsername(us.getUsername());
		if(user !=null) // da ton tai ussr trong csdl
		{
			map.addAttribute("mess", "tai khoan da dang ki");
			return "register";
		}
		
		userService.addUser(us);

		map.addAttribute("mess", "Dang ki thanh cong");
		
		return "login";
	}
	
	
	
	

}
