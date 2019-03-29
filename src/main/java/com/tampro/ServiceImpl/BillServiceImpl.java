package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.BillDAO;
import com.tampro.Model.Bill;
import com.tampro.Model.CartItem;
import com.tampro.Service.BillService;

@Service
public class BillServiceImpl  implements BillService{

	@Autowired
	BillDAO billDAO;
	
	public int addBill(Bill bill) {
		// TODO Auto-generated method stub
		return billDAO.addBill(bill);
	}

	public void deleteBillById(int id) {
		// TODO Auto-generated method stub
		
	}

	public Bill getBillById(int id) {
		// TODO Auto-generated method stub
		return billDAO.getBillById(id);
	}

	public List<Bill> getAllBillByIdUser(int id) {
		// TODO Auto-generated method stub
		return billDAO.getAllBillByIdUser(id);
	}

	public List<Bill> getAllBill() {
		// TODO Auto-generated method stub
		return billDAO.getAllBill();
	}

	public void updateBill(Bill bill) {
		// TODO Auto-generated method stub
		billDAO.updateBill(bill);
	}

	public List<CartItem> getBill() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		billDAO.addCartItem(cartItem);
	}

	public List<CartItem> getAllCartItemByIdBill(int idbill) {
		// TODO Auto-generated method stub
		return billDAO.getAllCartItemByIdBill(idbill);
	}

	public List<Bill> getAllBillByStatus(String status) {
		// TODO Auto-generated method stub
		return billDAO.getAllBillByStatus(status);
	}

}
