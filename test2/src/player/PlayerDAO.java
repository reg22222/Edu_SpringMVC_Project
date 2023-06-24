package player;
//DAO : Data Access Object
//실제 DB와 연결해서 CRUD 작업을 하는 클래스
import java.sql.*;
import java.util.*;

public class PlayerDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public PlayerDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int insertPlayer(PlayerDTO dto) {
		try {
			con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", 
										"web06", "web06");
			String sql = "insert into player "
					+"values(player_seq.nextval, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPosition());
			ps.setInt(3, dto.getSalary());
			ps.setString(4, dto.getTeamName());
			return ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertPlayer 실행 중 오류 발생!!");
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<PlayerDTO> listPlayer() {
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", 
											"web06", "web06");
			String sql = "select * from player";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<PlayerDTO> list = new ArrayList<>();
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				String position = rs.getString(3);
				int salary = rs.getInt(4);
				String teamName = rs.getString(5);
				PlayerDTO dto = new PlayerDTO();
				dto.setNum(num);
				dto.setName(name);
				dto.setPosition(position);
				dto.setSalary(salary);
				dto.setTeamName(teamName);
				list.add(dto);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int deletePlayer(int num) {
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", 
											"web06", "web06");
			String sql = "delete from player where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int editSalary(int num, int salary) {
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", 
											"web06", "web06");
			String sql = "update player set salary = ? where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, salary);
			ps.setInt(2, num);
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int editTeamName(int num, String teamName) {
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", 
											"web06", "web06");
			String sql = "update player set teamName = ? where num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, teamName);
			ps.setInt(2, num);
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}













