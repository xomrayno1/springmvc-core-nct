package com.tampro.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.BillDAO;
import com.tampro.Model.Bill;
import com.tampro.Model.CartItem;
import com.tampro.Model.Product;
import com.tampro.Service.ProductService;

@Repository
public class BillDAOImpl  implements BillDAO{

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ProductService productService;
	
	public int addBill(final Bill bill) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO bill ( iduser,status, date) VALUES ( ?, ?, ?)";

		 
		 KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, bill.getIdUser());
					ps.setString(2, bill.getStatus());
					ps.setString(3, LocalDateTime.now().toString());

					return ps;
				}
			},holder);
			int key = holder.getKey().intValue();
			return key;
	}

	public void deleteBillById(int id) {
		// TODO Auto-generated method stub
		
	}

	public Bill getBillById(int id) {
		String sql = "select * from bill where id = ?";
		List<Bill> listbill=  jdbcTemplate.query(sql, new Object[] {id},new RowMapper<Bill>() {

			public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bill bill = new Bill();
				bill.setDate(rs.getString("date"));
				bill.setIdBill(rs.getInt("id"));
				bill.setIdUser(rs.getInt("iduser"));
				bill.setStatus(rs.getString("status"));
				return bill;
			}
			
		});
		if(listbill==null)
		{
			return null;
		}
		return listbill.get(0);
	}

	public List<Bill> getAllBillByIdUser(int id) {
    String sql = "select * from bill where  iduser = ?";
		
		return jdbcTemplate.query(sql, new Object[] { id},new RowMapper<Bill>() {

			public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bill bill = new Bill();
				bill.setDate(rs.getString("date"));
				bill.setIdBill(rs.getInt("id"));
				bill.setIdUser(rs.getInt("iduser"));
				bill.setStatus(rs.getString("status"));
				return bill;
			}
			
		});
	}

	public List<Bill> getAllBill() {
		String sql = "select * from bill";
		
		return jdbcTemplate.query(sql, new Object[] {},new RowMapper<Bill>() {

			public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bill bill = new Bill();
				bill.setDate(rs.getString("date"));
				bill.setIdBill(rs.getInt("id"));
				bill.setIdUser(rs.getInt("iduser"));
				bill.setStatus(rs.getString("status"));
				return bill;
			}
			
		});
	}

	public void updateBill(Bill bill) {
		String sql = "update bill set iduser = ? ,date=?,status=? where id = ?";
		jdbcTemplate.update(sql,bill.getIdUser(),bill.getDate(),bill.getStatus(),bill.getIdBill());
		
	}

	

	public List<CartItem> getBill() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCartItem(CartItem cartItem) {
		String sql = "insert into cartitem(idproduct,totalPrice,quantity,date,idbill) values(?,?,?,?,?)";
		jdbcTemplate.update(sql,cartItem.getProduct().getIdProduct(),cartItem.getTotalPrice(),cartItem.getQuantity(),LocalDateTime.now().toString(),cartItem.getIdbill());
		
	}

	public List<CartItem> getAllCartItemByIdBill(int idbill) {
		String sql = "select * from cartitem where idbill = ?";
		return jdbcTemplate.query(sql,new Object[] {idbill},new RowMapper<CartItem>() {

			public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CartItem cartItem = new CartItem();
				cartItem.setIdbill(rs.getInt("idbill"));
				cartItem.setIdCartItem(rs.getInt("idcartitem"));
				Product product = productService.getProductbyId(rs.getInt("idproduct"));
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setTotalPrice(rs.getInt("totalPrice"));
				cartItem.setDate(rs.getString("date"));
				return cartItem;
			}
			
		});
	}

	public List<Bill> getAllBillByStatus(String status) {
       String sql = "select * from bill where  status = ?";
		
		return jdbcTemplate.query(sql, new Object[] { status},new RowMapper<Bill>() {

			public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bill bill = new Bill();
				bill.setDate(rs.getString("date"));
				bill.setIdBill(rs.getInt("id"));
				bill.setIdUser(rs.getInt("iduser"));
				bill.setStatus(rs.getString("status"));
				return bill;
			}
			
		});
	}
	
	
	
	

}
