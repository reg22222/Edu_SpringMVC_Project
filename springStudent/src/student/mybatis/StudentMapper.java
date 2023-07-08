package student.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import student.dto.StudentDTO;

public class StudentMapper {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e) {
			throw new RuntimeException("mybatis 설정 오류 발생!!", e);
		}
	}
	
	public static List<StudentDTO> listStudent(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<StudentDTO> list = sqlSession.selectList("listStudent");
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static List<StudentDTO> findStudent(String name){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<StudentDTO> list = sqlSession.selectList("findStudent", name);
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int insertStudent(StudentDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.insert("insertStudent", dto);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int deleteStudent(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.delete("deleteStudent", id);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
}








