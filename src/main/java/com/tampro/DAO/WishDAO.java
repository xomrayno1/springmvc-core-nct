package com.tampro.DAO;

import java.util.List;

import com.tampro.Model.Wish;

public interface WishDAO {
	
	public void addWish(Wish wish);
	
	public void DeleteWishById(int  id);
	
	public void UpdateWishByid(Wish wish);
	
	public Wish getWishByIdWish(int idWish);
	
	public List<Wish> getAllWishByIdUser(int id);

}
