package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private DataSource ds;
	private Context initContext, envContext;
	
	public MemberDAO() {
		try {
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:comp/env");
			ds = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isCheckMember(String name, String ssn1, String ssn2) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from member where ssn1=? and ssn2=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ssn1);
			ps.setString(2, ssn2);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}else {
				return false;
			}
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int insertMember(MemberDTO dto) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "insert into member values(member_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPasswd());
			ps.setString(4, dto.getSsn1());
			ps.setString(5, dto.getSsn2());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getHp1());
			ps.setString(8, dto.getHp2());
			ps.setString(9, dto.getHp3());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}











