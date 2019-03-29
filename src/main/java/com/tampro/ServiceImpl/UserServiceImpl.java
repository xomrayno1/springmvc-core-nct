package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.DAO.UserDAO;
import com.tampro.Model.Bill;
import com.tampro.Model.User;
import com.tampro.Service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO usDao;
	
	public User getUserByid(int id) {
		// TODO Auto-generated method stub
		return usDao.getUserByid(id);
	}

	public void updateUserByid(User us) {
		// TODO Auto-generated method stub
		usDao.updateUserByid(us);
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return usDao.getUserByUsername(username);
	}

	public void addUser(User us) {
		// TODO Auto-generated method stub
		usDao.addUser(us);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return usDao.getAllUser();
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		usDao.deleteUserById(id);
	}

	

}
