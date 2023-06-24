package board;

import java.sql.*;
import java.util.*;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	String url, user, pass;
	
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "web06";
		pass = "web06";
	}
	
	public List<BoardDTO> makeList(ResultSet rs) throws SQLException{
		List<BoardDTO> list = new ArrayList<>();
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			list.add(dto);
		}
		return list;
	}
	
	public List<BoardDTO> listBoard() throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from board order by num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int insertBoard(BoardDTO dto) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into board values"
			+ "(board_seq.nextval, ?,?,?,?, sysdate,0, ?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getPasswd());
			ps.setString(5, dto.getContent());
			ps.setString(6, dto.getIp());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	protected void plusReadcount(int num) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "update board set readcount = readcount+1"
					+" where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,  num);
			ps.executeUpdate();
			return;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public BoardDTO getBoard(int num, String mode) throws SQLException{
		if (mode.equals("content")) {
			plusReadcount(num);
		}
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from board where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list.get(0);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	protected boolean isPassword(int num, String passwd) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select passwd from board where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				String dbPass = rs.getString(1);
				if (dbPass.trim().equals(passwd)) {
					return true;
				}
			}
			return false;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deleteBoard(int num, String passwd) throws SQLException{
		boolean isPass = isPassword(num, passwd);
		if (isPass) {
			try {
				con = DriverManager.getConnection(url, user, pass);
				String sql = "delete from board where num = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				return ps.executeUpdate();
			}finally {
				if (ps != null) ps.close();
				if (con != null) con.close();	
			}
		}else {
			return -1;
		}
	}
	
	public int updateBoard(BoardDTO dto) throws SQLException {
		boolean isPass = isPassword(dto.getNum(), dto.getPasswd());
		if (isPass) {
			try {
				con = DriverManager.getConnection(url, user, pass);
				String sql = "update board set "
				+ "writer=?, subject=?, email=?, content=? where num = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getWriter());
				ps.setString(2, dto.getSubject());
				ps.setString(3, dto.getEmail());
				ps.setString(4, dto.getContent());
				ps.setInt(5, dto.getNum());
				return ps.executeUpdate();
			}finally {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}
		}else {
			return -1;
		}
	}
}













