package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.WishDAO;
import com.tampro.Model.Wish;
import com.tampro.Service.WishService;

@Service
public class WishServiceImpl implements WishService{

	@Autowired
	WishDAO wishDAO;
	
	public void addWish(Wish wish) {
		// TODO Auto-generated method stub
		wishDAO.addWish(wish);
	}

	public void DeleteWishById(int id) {
		// TODO Auto-generated method stub
		wishDAO.DeleteWishById(id);
	}

	public void UpdateWishByid(Wish wish) {
		// TODO Auto-generated method stub
		
	}

	public Wish getWishByIdWish(int idWish) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Wish> getAllWishByIdUser(int id) {
		// TODO Auto-generated method stub
		return wishDAO.getAllWishByIdUser(id);
	}

	

}
