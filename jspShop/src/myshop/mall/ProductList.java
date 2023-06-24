package myshop.mall;
import java.util.*;
import myshop.*;
import java.sql.*;

public class ProductList {
	Hashtable<String, List<ProductDTO>> ht;
	
	public ProductList() {
		ht = new Hashtable<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected List<ProductDTO> makeList(ResultSet rs) throws SQLException{
		List<ProductDTO> list = new ArrayList<>();
		while(rs.next()) {
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
			list.add(dto);
		}
		return list;
	}
	
	public List<ProductDTO> selectByPspec(String pspec) throws SQLException{
		Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "web06", "web06");
		String sql = "select * from product where pspec=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pspec);
		ResultSet rs = ps.executeQuery();
		List<ProductDTO> list = makeList(rs);
		ht.put(pspec, list);
		return list;
	}
	
	public List<ProductDTO> selectByCode(String code) throws SQLException {
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "web06", "web06");
		String sql = "select * from product where pcategory_fk like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, code+"%");
		ResultSet rs = ps.executeQuery();
		List<ProductDTO> list = makeList(rs);
		ht.put(code, list);
		return list;
	}
	
	public ProductDTO getProduct(String select, int pnum) {
		List<ProductDTO> list = ht.get(select);
		for(ProductDTO pdto : list) {
			if (pdto.getPnum() == pnum) {
				return pdto;
			}
		}
		return null;
	}
}














