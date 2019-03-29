package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.UserDAO;
import com.tampro.Model.User;

@Repository
public class UserDAOImpl  implements UserDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User getUserByid(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id = ?";
		List<User> listus =  jdbcTemplate.query(sql, new Object[] {id},new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User us = new User();
				us.setIdUser(rs.getInt("id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setrole(rs.getString("ROLE"));
				us.setEnabled(rs.getInt("ENABLED"));
				us.setAddress(rs.getString("address"));
				us.setDateCreated(rs.getString("dateCreated"));
				us.setSdt(rs.getString("sdt"));
				return us;
			}
			
		});
		if(listus.isEmpty())
		{
			return null;
			
		}
		return listus.get(0);
	}

	public void updateUserByid(User us) {
		// TODO Auto-generated method stub
		String sql = "update user set username = ? ,password= ?,ROLE=?,ENABLED=?,address=?,dateCreated=?,sdt=? where id = ?";
		jdbcTemplate.update(sql,us.getUsername(),us.getPassword(),us.getrole(),us.getEnabled(),us.getAddress(),us.getDateCreated(),us.getSdt(),us.getIdUser());
	}

	public User getUserByUsername(String username) {
		String sql = "select * from user where username = ?";
		List<User> list = jdbcTemplate.query(sql, new Object[] {username},new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User us = new User();
				us.setIdUser(rs.getInt("id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setrole(rs.getString("ROLE"));
				us.setEnabled(rs.getInt("ENABLED"));
				us.setAddress(rs.getString("address"));
				us.setDateCreated(rs.getString("dateCreated"));
				us.setSdt(rs.getString("sdt"));
				return us;
			}
			
		}) ;
		if(list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public void addUser(User us) {
		String sql = "insert into user(username,password,ROLE,ENABLED,address,dateCreated,sdt) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,us.getUsername(),us.getPassword(),us.getrole(),us.getEnabled(),us.getAddress(),LocalDateTime.now().toString(),us.getSdt());
		
	}

	public List<User> getAllUser() {
		String sql = "select * from user";
		
		return jdbcTemplate.query(sql, new Object[] {},new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User us = new User();
				us.setIdUser(rs.getInt("id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setrole(rs.getString("ROLE"));
				us.setEnabled(rs.getInt("ENABLED"));
				us.setAddress(rs.getString("address"));
				us.setDateCreated(rs.getString("dateCreated"));
				us.setSdt(rs.getString("sdt"));
				return us;
			}
			
		}) ;
	}

	public void deleteUserById(int id) {
		String sql = "delete from user where id = ?";
		jdbcTemplate.update(sql,id);
		
	}

}
