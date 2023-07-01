package myShop.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import myShop.admin.dto.CategoryDTO;

public class CategoryDAOImpl implements CategoryDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertCategory(CategoryDTO dto) {
		String sql = "insert into category values(cate_seq.nextval, ?, ?)";
		Object[] values = new Object[] {dto.getCode(), dto.getCname()};
		return jdbcTemplate.update(sql, values);
	}

	@Override
	public int deleteCategory(int cnum) {
		String sql = "delete from category where cnum = ?";
		return jdbcTemplate.update(sql, cnum);
	}

	@Override
	public List<CategoryDTO> listCategory() {
		String sql = "select * from category";
		RowMapper<CategoryDTO> mapper = new RowMapper<CategoryDTO>() {
			@Override
			public CategoryDTO mapRow(ResultSet rs, int co) throws SQLException {
				CategoryDTO dto = new CategoryDTO();
				dto.setCnum(rs.getInt("cnum"));
				dto.setCode(rs.getString("code"));
				dto.setCname(rs.getString("cname"));
				return dto;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}

}













