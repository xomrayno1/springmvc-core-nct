package com.tampro.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tampro.Methodd.ExcelOrder;
import com.tampro.Model.Bill;
import com.tampro.Model.Category;
import com.tampro.Model.Product;
import com.tampro.Model.User;
import com.tampro.Service.BillService;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;	
	@Autowired
	BillService billService;
	
	@RequestMapping("/home") // trang chu admin
	public String home(ModelMap map) 
	{
		return "homeAdmin";
		
	}
	@RequestMapping("/dang-xuat") //dang xuat tai khoan ve tran dang nhap
	public String logout(ModelMap map,HttpServletRequest request,HttpServletResponse response)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication !=null)
		{
			SecurityContextLogoutHandler contextLogoutHandler = new SecurityContextLogoutHandler();
			contextLogoutHandler.logout(request, response, authentication);
		}		
		
		return  "redirect:/login-admin";
	}
	@RequestMapping("/them-san-pham") // form them san pham
	public String addProduct(ModelMap map) 
	{
		
		map.addAttribute("product", new Product());
		return "addproduct";		
	}
	@RequestMapping("/add-product") // form them san pham
	public String addProduct(ModelMap map,@ModelAttribute("product") @Valid Product product,BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors())
		{
			
			return "addproduct";
		}
		
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\BanHangSpringMVCSpring\\src\\main\\webapp\\resources\\images\\"
	+product.getMultipartResolver().getOriginalFilename());
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(product.getMultipartResolver().getBytes());
			product.setImagesProduct("images/"+product.getMultipartResolver().getOriginalFilename());
			fileOutputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		productService.addProduct(product);
		map.addAttribute("product", new Product());
		map.addAttribute("mess", "them san pham thanh cong");
		
		return "addproduct";		
	}
	
	@RequestMapping("/tat-ca-san-pham") // tat ca san pham
	public String allProduct(ModelMap map) 
	{
		map.addAttribute("listProduct", productService.getAllProduct());
		map.addAttribute("category", categoryService.getAllListCategory());
		
		return "allproduct";		
	}
	@RequestMapping("/locproduct") // tat ca san pham
	public String locproduct(ModelMap map,@RequestParam("category") int category) 
	{
		
		map.addAttribute("listProduct", productService.getAllProductByIdCategory(category));
		map.addAttribute("category", categoryService.getAllListCategory());
		return "allproduct";		
	}
	@RequestMapping("/them-nguoi-dung") // trang chu admin
	public String addUser(ModelMap map) 
	{
		map.addAttribute("user", new User());
		return "adduser";		
	}
	
	@RequestMapping("/tat-ca-nguoi-dung") // trang chu admin
	public String allUser(ModelMap map) 
	{
		map.addAttribute("listUser", userService.getAllUser());
		return "user";		
	}
	@RequestMapping(value="/add-user")
	public String login(ModelMap map,@ModelAttribute("user") @Valid User us,BindingResult bindingResult)
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		
		if(bindingResult.hasErrors())
		{
			
			return "adduser";
		}
		User user = userService.getUserByUsername(us.getUsername());
		if(user !=null) // da ton tai ussr trong csdl
		{
			map.addAttribute("mess", "tai khoan da dang ki");
			return "adduser";
		}
		
		userService.addUser(us);

		map.addAttribute("mess", "Them Thanh Cong");
		
		return "adduser";
	}
	@RequestMapping("/them-danh-muc") // form add category
	public String category(ModelMap map) 
	{
		map.addAttribute("category", new Category());
		return "addcategory";		
	}
	@RequestMapping(value="/add-category")
	public String category1(ModelMap map,@ModelAttribute("category") @Valid Category category,BindingResult bindingResult) //logic
	{
		
		
		if(bindingResult.hasErrors())
		{
			
			return "addcategory";
		}
		
		
		categoryService.addCategory(category);

		map.addAttribute("mess", "Them Thanh Cong");
		
		return "addcategory";
	}

	@RequestMapping("/update/{update}") // trang chu admin
	public String update(ModelMap map,@RequestParam("idUser")int idUser,@PathVariable("update")String update,
			@RequestParam(value="role",required=false)String role) 
	{
		if(update.equals("xoa"))
		{
			userService.deleteUserById(idUser);
			return "redirect:/admin/tat-ca-nguoi-dung";
		}
		else
		{
			User us = userService.getUserByid(idUser);
			us.setrole(role);
			userService.updateUserByid(us);
			return "redirect:/admin/tat-ca-nguoi-dung";
		}

	}
	
	@RequestMapping("/tat-ca-don-hang") // tat ca san pham
	public String bill(ModelMap map) 
	{
		
		map.addAttribute("bill", billService.getAllBill());
		
		
		//map.addAttribute("bill", cartService.getBill());
		
		return "order";		
	}
	@RequestMapping("/chi-tiet-don-hang") // chi tiet don hang
	public String order(ModelMap map,@RequestParam("idbill")int idbill,@RequestParam("iduser")int iduser) 
	{
		
		map.addAttribute("bill", billService.getAllCartItemByIdBill(idbill));
		map.addAttribute("user", userService.getUserByid(iduser));
		
		//map.addAttribute("bill", cartService.getBill());
		
		return "billorder";		
	}
	@RequestMapping("/xu-ly") // update xu ly
	public String xuly(ModelMap map,@RequestParam("idbill")int idbill) 
	{
		Bill bill = billService.getBillById(idbill);
		bill.setStatus("da xu ly");
		billService.updateBill(bill);
		
		
		//map.addAttribute("bill", cartService.getBill());
		
		return "redirect:/admin/tat-ca-don-hang";		
	}
	
	@RequestMapping("/locorder") // tat ca san pham
	public String loc(ModelMap map,@RequestParam("status")int status) 
	{
		if(status==0)
		{
			map.addAttribute("bill", billService.getAllBillByStatus("chua xu ly"));
		}
		else 
		{
			map.addAttribute("bill", billService.getAllBillByStatus("da xu ly"));
		}
		
		
		
		return "order";		
	}
	@RequestMapping("/category") // tat ca san pham
	public String allcategory(ModelMap map) 
	{
		map.addAttribute("category", categoryService.getAllListCategory());
		
		return "category";		
	}
	
	@RequestMapping("/xuat-excel")
	public ModelAndView downloadExcel()
	{
		List<Bill> listbill = billService.getAllBill();
		
		return new ModelAndView(new ExcelOrder(), "listbill", listbill);
	}
	@RequestMapping("/update-product") // tat ca san pham
	public String updateProduct(ModelMap map,@RequestParam("idproduct") int idproduct) 
	{
		Product product = productService.getProductbyId(idproduct);
		map.addAttribute("product", product);
		
		return "updateproduct";		
	}
	@RequestMapping("/edit") // logic
	public String updateProduct1(ModelMap map,@ModelAttribute("product") Product product ) 
	{


		
		productService.updateProduct(product);
		
		
		return "redirect:/admin/tat-ca-san-pham";	
	}
	@RequestMapping("/delete-danh-muc") // tat ca san pham
	public String deletecategory(ModelMap map,@RequestParam("idcategory") int idcategory) 
	{
		categoryService.deleteCategoryByid(idcategory);
		
		return "redirect:/admin/category";		
	}
	@RequestMapping("/delete-san-pham") // tat ca san pham
	public String deleteproduct(ModelMap map,@RequestParam("idproduct") int idproduct) 
	{
		productService.deleteProductById(idproduct);
		
		return "redirect:/admin/tat-ca-san-pham";		
	}
	
	
	
}
