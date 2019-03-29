package com.tampro.Service;

import java.util.List;

import com.tampro.Model.Bill;
import com.tampro.Model.User;

public interface UserService {
	
    public User getUserByid(int id);
	
	public void updateUserByid(User us);
	
	public User getUserByUsername(String username);

	
	public void addUser(User us);
	
	public List<User> getAllUser();
	
	public void deleteUserById(int id);
	
	
}
