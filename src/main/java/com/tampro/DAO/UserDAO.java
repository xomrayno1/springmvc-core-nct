package com.tampro.DAO;

import java.util.List;

import com.tampro.Model.User;

public interface UserDAO {
	
	public User getUserByid(int id);
	
	public User getUserByUsername(String username);
	
	public void updateUserByid(User us);
	
	public void addUser(User us);
	
	public List<User> getAllUser();
	
	public void deleteUserById(int id);

}
