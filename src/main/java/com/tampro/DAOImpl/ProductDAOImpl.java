package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.ProductDAO;
import com.tampro.Model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addProduct(Product product) {
		String sql = "insert into product(nameProduct,discountProduct,priceProduct,dateCreatedProduct,viewProduct,imagesProduct"
				+ ",quantityProduct,idCategory,urlProduct,ramProduct,loaiproduct) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql,product.getNameProduct(),product.getDiscountProduct(),product.getPriceProduct(),LocalDateTime.now().toString(),
				product.getViewProduct(),product.getImagesProduct(),product.getQuantityProduct(),product.getIdCategory(),product.getUrlProduct(),
				product.getRamProduct(),product.getLoaiProduct());
	}

	public List<Product> getAllProduct() {
        String sql = "select * from product  ";
		
		return jdbcTemplate.query(sql,new Object[] {},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public List<Product> getAllProductByIdCategory(int idCategory) {
		// TODO Auto-generated method stub
		String sql = "select * from product where idCategory = ? ";
		
		return jdbcTemplate.query(sql,new Object[] {idCategory},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public Product getProductbyId(int id) {
		// TODO Auto-generated method stub

		String sql = "select * from product where idproduct = ?";
		
		
		List<Product> list = jdbcTemplate.query(sql,new Object[] {id},new RowMapper<Product>() {

			 public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
		if(list.isEmpty())
		{
			return null;
		}
		 return list.get(0);
	}

	public void updateProduct(Product product) {
		String sql = "update product set nameProduct = ? ,discountProduct=?,priceProduct=?,dateCreatedProduct=?,viewProduct=?,imagesProduct=?,quantityProduct=?,idCategory=?,urlProduct=?,ramProduct=?,loaiproduct=? where idproduct=?";
		jdbcTemplate.update(sql,product.getNameProduct(),product.getDiscountProduct(),product.getPriceProduct(),product.getDateCreatedProduct()
				,product.getViewProduct(),product.getImagesProduct()
				,product.getQuantityProduct(),product.getIdCategory(),product.getUrlProduct(),product.getRamProduct(),product.getLoaiProduct(),product.getIdProduct());
	}

	public void deleteProductById(int id) {
		String sql = "delete from product where idproduct = ? ";
		jdbcTemplate.update(sql,id);
		
	}

	public List<Product> findProductByNameProductNav(String nameproduct,int frist, int last) {
     
      String sql = "select * from product  where nameProduct LIKE ? limit  ? , ?";
		
		return jdbcTemplate.query(sql,new Object[] {"%" + nameproduct + "%",frist,last},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public List<Product> getAllProductByIdCategoryAndLoai(int idCategory, String loai) {
		// TODO Auto-generated method stub
         String sql = "select * from product where idCategory = ?  and loaiproduct = ?";
		
		return jdbcTemplate.query(sql,new Object[] {idCategory,loai},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public int countProductByIdCategory(int category) {
		String sql = "select count(*) from product where idCategory = ?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] {category},Integer.class);
        return count;
	}

	public int countProductByIdCategoryAndLoai(int idCategory, String loai) {
		String sql = "SELECT count(*) from product where idCategory = ? and  loaiproduct = ?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] {idCategory,loai},Integer.class);
        return count;
	}

	public List<Product> getProductByNav(int frist, int last, int idCategory) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product where idCategory = ? limit ? , ?";

		
		return jdbcTemplate.query(sql,new Object[] {idCategory,frist,last},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public List<Product> getProductByNavAndLoai(int frist, int last, int idCategory, String loai) {
		// TODO Auto-generated method stub
		String sql = "select * from product  where idCategory =  ?  and loaiproduct =  ? limit  ? , ? ";
		
		return jdbcTemplate.query(sql,new Object[] {idCategory,loai,frist,last},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public List<Product> getProductByPage(int idCategory) {
		// TODO Auto-generated method stub
		String sql = "select * from product  where idCategory =  ? limit  6 ";
		
		return jdbcTemplate.query(sql,new Object[] {idCategory},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public Product getProductUrl(String url) {
      String sql = "select * from product where urlProduct = ?";
		
		
		List<Product> list = jdbcTemplate.query(sql,new Object[] {url},new RowMapper<Product>() {

			 public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
		 return list.get(0);
	}

	public List<Product> getProductViewMax() {
		String sql = "select * from product ORDER BY viewProduct DESC LIMIT 6";
		
		return jdbcTemplate.query(sql,new Object[] {},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public List<Product> getProductViewApple() {
     String sql = "select * from product where idCategory = 4 ORDER BY viewProduct DESC LIMIT 4";
		
		return jdbcTemplate.query(sql,new Object[] {},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public List<Product> getProductViewSamsung() {
		 String sql = "select * from product where idCategory = 1 ORDER BY viewProduct DESC LIMIT 4";
			
			return jdbcTemplate.query(sql,new Object[] {},new RowMapper<Product>() {

				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product();
					product.setIdProduct(rs.getInt("idproduct"));
					product.setNameProduct(rs.getString("nameProduct"));
					product.setDiscountProduct(rs.getInt("discountProduct"));
					product.setPriceProduct(rs.getInt("priceProduct"));
					product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
					product.setViewProduct(rs.getInt("viewProduct"));
					product.setImagesProduct(rs.getString("imagesProduct"));
					product.setQuantityProduct(rs.getInt("quantityProduct"));
					product.setIdCategory(rs.getInt("idCategory"));
					product.setUrlProduct(rs.getString("urlProduct"));
					product.setRamProduct(rs.getInt("ramProduct"));
					product.setLoaiProduct(rs.getString("loaiproduct"));
					return product;
				}
				
			});
	}

	public List<Product> getProductViewXiaomi() {
		String sql = "select * from product where idCategory = 5 ORDER BY viewProduct DESC LIMIT 4";
		
		return jdbcTemplate.query(sql,new Object[] {},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

	public List<Product> getProductViewSony() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductViewNokia() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> ListfindProductByNameProduct(String nameproduct) {
      String sql = "select * from product  where nameProduct LIKE ?";
		
		return jdbcTemplate.query(sql,new Object[] {"%" + nameproduct + "%"},new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idproduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setDiscountProduct(rs.getInt("discountProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setDateCreatedProduct(rs.getString("dateCreatedProduct"));
				product.setViewProduct(rs.getInt("viewProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setQuantityProduct(rs.getInt("quantityProduct"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setRamProduct(rs.getInt("ramProduct"));
				product.setLoaiProduct(rs.getString("loaiproduct"));
				return product;
			}
			
		});
	}

}
