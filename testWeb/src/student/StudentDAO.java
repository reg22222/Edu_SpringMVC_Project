package student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String url, user, pass;
	
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "web06";
		pass = "web06";
	}
	
	public int insertStudent(StudentDTO dto) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into student values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getCname());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<StudentDTO> listStudent() throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<StudentDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deleteStudent(String id) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "delete from student where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<StudentDTO> makeList(ResultSet rs) throws SQLException{
		List<StudentDTO> list = new ArrayList<>();
		while(rs.next()) {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));
			list.add(dto);
		}
		return list;
	}
	
	public List<StudentDTO> findStudent(String name) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from student where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			List<StudentDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}









