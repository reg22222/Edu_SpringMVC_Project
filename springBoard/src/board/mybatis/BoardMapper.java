package board.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.dto.BoardDTO;

public class BoardMapper {
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
	
	public static List<BoardDTO> listBoard(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<BoardDTO> list = sqlSession.selectList("listBoard");
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int insertBoard(BoardDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.insert("insertBoard", dto);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static void plusReadcount(int num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.update("plusReadcount", num);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	public static BoardDTO getBoard(int num, String mode){
		if (mode.equals("content")) {
			plusReadcount(num);
		}
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			BoardDTO dto = sqlSession.selectOne("getBoard", num);
			return dto;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int deleteBoard(Map<String, String> map) {
		BoardDTO dto = getBoard(Integer.parseInt(map.get("num")), "password");
		if (!dto.getPasswd().equals(map.get("passwd"))) {
			return -1;
		}
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.delete
							("deleteBoard", Integer.parseInt(map.get("num")));
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int updateBoard(BoardDTO dto) {
		BoardDTO dto2 = getBoard(dto.getNum(), "password");
		if (!dto.getPasswd().equals(dto2.getPasswd())) {
			return -1;
		}
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.update("updateBoard", dto);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
}








