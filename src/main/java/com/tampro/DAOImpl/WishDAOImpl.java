package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.tampro.DAO.WishDAO;
import com.tampro.Model.Product;
import com.tampro.Model.Wish;

@Service
public class WishDAOImpl  implements WishDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addWish(Wish wish) {
		String sql = "insert into wish (idproduct,dateWish,idUser) values (?,?,?)";
		jdbcTemplate.update(sql,wish.getIdproduct(),LocalDateTime.now().toString(),wish.getIdUser());
		
	}

	public void DeleteWishById(int id) {
		String sql = "delete from wish where idproduct = ? ";
		jdbcTemplate.update(sql,id);
	}

	public void UpdateWishByid(Wish wish) {
		// TODO Auto-generated method stub
		
	}

	public Wish getWishByIdWish(int idWish) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Wish> getAllWishByIdUser(int id) {
		String sql = "select * from wish where idUser=?";
		return jdbcTemplate.query(sql, new Object[] {id},new RowMapper<Wish>() {

			public Wish mapRow(ResultSet rs, int rowNum) throws SQLException {
				Wish wish = new Wish();
				wish.setDateWish(rs.getString("dateWish"));
				wish.setIdUser(rs.getInt("idUser"));
				wish.setIdproduct(rs.getInt("idproduct"));
				return wish;
			}
			
		});
		
	}

	
}
