package myShop.mall.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import myShop.admin.dto.ProductDTO;

public class ProductList {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	Hashtable<String, List<ProductDTO>> ht;
	
	public ProductList() {
		ht = new Hashtable<>();
	}
	
	class MyRowMapper implements RowMapper<ProductDTO>{

		@Override
		public ProductDTO mapRow(ResultSet rs, int co) throws SQLException {
			ProductDTO dto = new ProductDTO();
			dto.setPnum(rs.getInt("pnum"));
			dto.setPname(rs.getString("pname"));
			dto.setPcategory_fk(rs.getString("pcategory_fk"));
			dto.setPcompany(rs.getString("pcompany"));
			dto.setPimage(rs.getString("pimage"));
			dto.setPqty(rs.getInt("pqty"));
			dto.setPrice(rs.getInt("price"));
			dto.setPspec(rs.getString("pspec"));
			dto.setPcontents(rs.getString("pcontents"));
			dto.setPoint(rs.getInt("point"));
			dto.setPinputdate(rs.getString("pinputdate"));
			return dto;
		}
	}
	
	private MyRowMapper mapper = new MyRowMapper();
	
	public List<ProductDTO> selectByPspec(String pspec){
		String sql = "select * from product where pspec=?";
		List<ProductDTO> list = jdbcTemplate.query(sql, mapper, pspec);
		ht.put(pspec, list);
		return list;
	}
	
	public List<ProductDTO> selectByCode(String code){
		String sql = "select * from product where pcategory_fk like ?";
		List<ProductDTO> list = jdbcTemplate.query(sql, mapper, code+"%");
		ht.put(code, list);
		return list;
	}
	
	public ProductDTO getProduct(Map<String, String> map) {
		List<ProductDTO> list = ht.get(map.get("select"));
		int pnum = Integer.parseInt(map.get("pnum"));
		for(ProductDTO pdto : list) {
			if (pdto.getPnum() == pnum) {
				return pdto;
			}
		}
		return null;
	}
}
