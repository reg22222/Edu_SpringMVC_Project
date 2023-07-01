package myShop.admin.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import myShop.admin.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int insertProduct(ProductDTO dto) {
		String sql = "insert into product values ("
				+ "prod_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
		Object[] values = new Object[] {dto.getPname(), dto.getPcategory_fk(), 
			dto.getPcompany(), dto.getPimage(), dto.getPqty(), dto.getPrice(), 
			dto.getPspec(), dto.getPcontents(), dto.getPoint()};
		return jdbcTemplate.update(sql, values);
	}

}
