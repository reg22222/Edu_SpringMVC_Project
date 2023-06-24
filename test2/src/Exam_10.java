import java.sql.*;

public class Exam_10 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 설치 성공!!");
		}catch(ClassNotFoundException e) {
			System.err.println("오라클 드라이버 설치 실패!!");
		}
		
		Connection con = null;
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", 
					"web06", "web06");//오라클위치, 계정아이디, 비밀번호
			System.out.println("오라클 연결 성공!!");	
		}catch(SQLException e) {
			System.out.println("오라클 연결 실패!!");
		}
		
		//DML문을 이용하여 자료 처리하기
		//쿼리문 처리 3가지
		//- 정적쿼리방식, - 동적쿼리방식 : PreparedStatement, - 구문처리방식
		PreparedStatement ps = null;
		try {
			String sql = "insert into test01 values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 5);
			ps.setString(2, "수지");
			ps.setString(3, "444-4444");
			int res = ps.executeUpdate();
			if (res>0) {
				System.out.println("수지 입력 성공!!");
			}else {
				System.out.println("수지 입력 실패!!");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		/*
		try {
			String sql = "select * from test01 where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "홍길동");
			ResultSet rs = ps.executeQuery();
			//쿼리문이 select일경우, ResultSet타입으로 결과를 받고,
			//결과를 묻는 메소드는 executeQuery() 이다.
			//쿼리문이 insert, delete, update 일 경우, int로 결과를 받고,
			//결과를 묻는 메소드는 executeUpdate() 이다.
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				System.out.println(no + "\t" + name + "\t" + tel);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		*/
	}
}













