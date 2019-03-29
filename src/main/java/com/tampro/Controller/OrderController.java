package com.tampro.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.Model.Bill;
import com.tampro.Model.CartItem;
import com.tampro.Model.User;
import com.tampro.Service.BillService;
import com.tampro.Service.CategoryService;
import com.tampro.Service.UserService;

@Controller
@RequestMapping("/user")
public class OrderController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;
	@Autowired
	BillService billService;
	
	@RequestMapping("/thanh-toan")
	public String order(ModelMap map,HttpSession httpSession)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		
	
		return "thanhtoan";
	}
	
	/*
	 @RequestMapping("/chap-nhan")
	public String order1(ModelMap map,HttpSession httpSession)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		
		List<CartItem> listCartItem = (List<CartItem>)httpSession.getAttribute("listCartItem");
		
		if(listCartItem==null)
		{
			map.addAttribute("category", categoryService.getAllListCategory());
			map.addAttribute("mess", "Gio hang null");
			return "thanhtoan";
		}
		else25
		{
			Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
			User us = userService.getUserByUsername(authentication.getName());
			for(CartItem  cart : listCartItem)
			{
				Order od = new Order();			
				int idCart = orderService.addCartitem(cart);
				od.setIdCartItem(idCart);
				od.setIdUser(us.getIdUser());
				od.setStatus(0);
				orderService.addOrder(od);
			}
			httpSession.removeAttribute("listCartItem");
			map.addAttribute("mess", "Thanh Toan Thanh Cong");
		
			return "thanhtoan";
		}
	}
	 */
	@RequestMapping("/chap-nhan")
	public String order1(ModelMap map,HttpSession httpSession)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		
		List<CartItem> listCartItem = (List<CartItem>)httpSession.getAttribute("listCartItem");
		
		if(listCartItem==null)
		{
			map.addAttribute("category", categoryService.getAllListCategory());
			map.addAttribute("mess", "Gio hang null");
			return "thanhtoan";
		}
		else
		{
			Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
			User us = userService.getUserByUsername(authentication.getName());
			Bill bill = new Bill();
			bill.setIdUser(us.getIdUser());
			bill.setStatus("chua xu ly");
			int idbill = billService.addBill(bill);
			for(CartItem  cart : listCartItem)
			{
				
				CartItem cartitem = new CartItem();
				cartitem.setIdbill(idbill);
				cartitem.setProduct(cart.getProduct());
				cartitem.setQuantity(cart.getQuantity());
				cartitem.setTotalPrice(cart.getTotalPrice());
				billService.addCartItem(cartitem);
			
			}
			httpSession.removeAttribute("listCartItem");
			map.addAttribute("mess", "Thanh Toan Thanh Cong");
		
			return "thanhtoan";
		}
	}

}
