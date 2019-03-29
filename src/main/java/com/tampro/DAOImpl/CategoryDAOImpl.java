package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.CategoryDAO;
import com.tampro.Model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Category> getAllListCategory() {
		// TODO Auto-generated method stub
		String sql = "select * from category";
		return jdbcTemplate.query(sql, new Object[] {},new RowMapper<Category>() {

			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category category = new Category();
				category.setIdCategory(rs.getInt("idcategory"));
				category.setNameCategory(rs.getString("nameCategory"));
				category.setUrlCategory(rs.getString("urlCategory"));
				return category;
			}
		});
	}

	public void addCategory(Category category) {
		String sql = "insert into category(nameCategory,urlCategory) values(?,?)";
		jdbcTemplate.update(sql,category.getNameCategory(),category.getUrlCategory());
	}

	public void updateCategoryByid(Category category) {
		// TODO Auto-generated method stub
		
	}

	

	public void deleteCategoryByid(int idcategory) {
		String sql = "delete from category where idcategory = ? ";
		jdbcTemplate.update(sql,idcategory);
		
	}

}
