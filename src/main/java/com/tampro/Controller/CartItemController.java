package com.tampro.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.CartItem;
import com.tampro.Model.Product;
import com.tampro.Model.User;
import com.tampro.Service.BillService;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.UserService;

@Controller
@RequestMapping("/user")
public class CartItemController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	BillService billService;
	
	@RequestMapping("/cartitem/{url}/{idProduct}")
	public String CartItem1(ModelMap map,HttpSession httpSession,@PathVariable("idProduct")int idProduct,@PathVariable("url")String url)
	{
		List<CartItem> listCartItem = (List<CartItem>)  httpSession.getAttribute("listCartItem");
		if(listCartItem==null) // gio hang chua co gi 
		{
			List<CartItem> listCart= new ArrayList<CartItem>();
			Product product = productService.getProductbyId(idProduct);
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getPriceProduct());
			cartItem.setDate(LocalDateTime.now().toString());
			
			listCart.add(cartItem);
			httpSession.setAttribute("listCartItem", listCart);
		}
		else
		{
			Product product = productService.getProductbyId(idProduct);
			boolean kt = true;
			for(CartItem cart : listCartItem)
			{
				if(cart.getProduct().getIdProduct()==product.getIdProduct())
				{
					cart.setQuantity(cart.getQuantity()+1);
					cart.setTotalPrice(cart.getTotalPrice()+product.getPriceProduct());
					kt = false;
				}
			}
			if(kt)
			{
				CartItem cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				cartItem.setTotalPrice(product.getPriceProduct()*cartItem.getQuantity());
				cartItem.setDate(LocalDateTime.now().toString());
				listCartItem.add(cartItem);	
			}
		
			httpSession.setAttribute("listCartItem", listCartItem);
		}
			
		return "redirect:/"+url;
	}
	@RequestMapping("/cartitem/{idProduct}")
	public String CartItem2(ModelMap map,HttpSession httpSession,@PathVariable("idProduct")int idProduct
			,@RequestParam("quantity") int quantity)
	{
		List<CartItem> listCartItem = (List<CartItem>)  httpSession.getAttribute("listCartItem");
		if(listCartItem==null) // gio hang chua co gi 
		{
			List<CartItem> listCart= new ArrayList<CartItem>();
			Product product = productService.getProductbyId(idProduct);
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(quantity);
			cartItem.setTotalPrice(product.getPriceProduct()*quantity);
			cartItem.setDate(LocalDateTime.now().toString());
			
			listCart.add(cartItem);
			httpSession.setAttribute("listCartItem", listCart);
		}
		else
		{
			Product product = productService.getProductbyId(idProduct);
			boolean kt = true;
			for(CartItem cart : listCartItem)
			{
				if(cart.getProduct().getIdProduct()==product.getIdProduct())
				{
					cart.setQuantity(cart.getQuantity()+quantity);
					cart.setTotalPrice(cart.getProduct().getPriceProduct()*cart.getQuantity());
					kt = false;
				}
			}
			if(kt)
			{
				CartItem cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQuantity(quantity);
				cartItem.setTotalPrice(product.getPriceProduct()*quantity);
				cartItem.setDate(LocalDateTime.now().toString());
				listCartItem.add(cartItem);	
			}
		
			httpSession.setAttribute("listCartItem", listCartItem);
		}
			
		return "redirect:/home";
	}
	@RequestMapping("/cart")
	public String cart(ModelMap map,HttpSession httpSession)
	{
		map.addAttribute("category", categoryService.getAllListCategory());

		return "cart";
	}
	@RequestMapping("/update-cart")
	public String updatecart(ModelMap map,HttpSession httpSession,@RequestParam(value="idProduct") int idProduct
			,@RequestParam(value="quantity") int quantity)
	{
		
		List<CartItem> listCartItem = (List<CartItem>)  httpSession.getAttribute("listCartItem");
		Product product = productService.getProductbyId(idProduct);
			for(CartItem cart : listCartItem)
			{
				if(cart.getProduct().getIdProduct() == product.getIdProduct())
				{
					cart.setQuantity(quantity);
					cart.setTotalPrice(cart.getProduct().getPriceProduct() * quantity);
					break;
				}
			}
			httpSession.setAttribute("listCartItem", listCartItem);
			return "redirect:/user/cart";
		
	}
	@RequestMapping("/drop-cart")
	public String drop(ModelMap map,HttpSession httpSession,@RequestParam(value="idProduct") int idProduct
			)
	{
		
		List<CartItem> listCartItem = (List<CartItem>)  httpSession.getAttribute("listCartItem");
		Product product = productService.getProductbyId(idProduct);
			for(CartItem cart : listCartItem)
			{
				if(cart.getProduct().getIdProduct()==product.getIdProduct())
				{
					listCartItem.remove(cart);
					break;
				}
			}
	    httpSession.setAttribute("listCartItem", listCartItem);
		
		return "redirect:/user/cart";
	}
	@RequestMapping("/lich-su-dat-hang")
	public String cart1(ModelMap map)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getUserByUsername(authentication.getName());
		
		map.addAttribute("bill", billService.getAllBillByIdUser(user.getIdUser()));
		
		
		return "lichsudathang";
	}
	@RequestMapping("/chi-tiet-don-hang")
	public String cart1(ModelMap map,@RequestParam("idbill")int idbill)
	{
		
		
		map.addAttribute("category", categoryService.getAllListCategory());
		map.addAttribute("bill", billService.getAllCartItemByIdBill(idbill));
		
		return "chitietdonhang";
	}

}
