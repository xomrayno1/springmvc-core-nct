package com.tampro.DAO;

import java.util.List;

import com.tampro.Model.Bill;
import com.tampro.Model.CartItem;

public interface BillDAO {
    
	public int addBill(Bill bill);
	
	public void deleteBillById(int id);
	
	
	public Bill getBillById(int id);
	
	public List<Bill> getAllBillByIdUser(int id);
	
	public List<Bill> getAllBill();
	
	public void updateBill(Bill bill);
	
	
	
	public List<CartItem> getBill();
	
	public void addCartItem(CartItem cartItem);
	
	public List<CartItem> getAllCartItemByIdBill(int idbill);
	
	public List<Bill> getAllBillByStatus(String status);
	

}
