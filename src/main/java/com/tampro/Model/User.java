package com.tampro.Model;

import org.hibernate.validator.constraints.Length;

public class User {
	private int idUser;

	@Length(min=6,max=12)
	private String username;

	@Length(min=5,max=12)
	private String password;
	
	private int enabled; // tai khoan co khoa hay ko 
	
	private String role;
	@Length(min=5,max=100)
	private String address; 
	private String dateCreated; // thoi gian tao user
	@Length(min=10,max=12)
	private String sdt;
	
	
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}
	
	

}
