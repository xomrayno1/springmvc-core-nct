package com.tampro.Model;

public class Wish { // 1-1 user / 1-n product
	private int idWish;
	private int idproduct;
	private String dateWish;
	private int idUser;
	
	
	
	
	
	
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public int getIdWish() {
		return idWish;
	}
	public void setIdWish(int idWish) {
		this.idWish = idWish;
	}
	
	public String getDateWish() {
		return dateWish;
	}
	public void setDateWish(String dateWish) {
		this.dateWish = dateWish;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
	

}
