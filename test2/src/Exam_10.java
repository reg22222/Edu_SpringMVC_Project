import java.sql.*;

public class Exam_10 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����Ŭ ����̹� ��ġ ����!!");
		}catch(ClassNotFoundException e) {
			System.err.println("����Ŭ ����̹� ��ġ ����!!");
		}
		
		Connection con = null;
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", 
					"web06", "web06");//����Ŭ��ġ, �������̵�, ��й�ȣ
			System.out.println("����Ŭ ���� ����!!");	
		}catch(SQLException e) {
			System.out.println("����Ŭ ���� ����!!");
		}
		
		//DML���� �̿��Ͽ� �ڷ� ó���ϱ�
		//������ ó�� 3����
		//- �����������, - ����������� : PreparedStatement, - ����ó�����
		PreparedStatement ps = null;
		try {
			String sql = "insert into test01 values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 5);
			ps.setString(2, "����");
			ps.setString(3, "444-4444");
			int res = ps.executeUpdate();
			if (res>0) {
				System.out.println("���� �Է� ����!!");
			}else {
				System.out.println("���� �Է� ����!!");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		/*
		try {
			String sql = "select * from test01 where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "ȫ�浿");
			ResultSet rs = ps.executeQuery();
			//�������� select�ϰ��, ResultSetŸ������ ����� �ް�,
			//����� ���� �޼ҵ�� executeQuery() �̴�.
			//�������� insert, delete, update �� ���, int�� ����� �ް�,
			//����� ���� �޼ҵ�� executeUpdate() �̴�.
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













