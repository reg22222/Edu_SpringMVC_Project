package member.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.dto.MemberDTO;

public class MemberMapper {
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
	
	public static boolean isCheckMember(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			MemberDTO dto = sqlSession.selectOne("checkMember", map);
			if (dto == null) return false;
			return true;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int insertMember(MemberDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.insert("insertMember", dto);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static List<MemberDTO> listMember() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<MemberDTO> list = sqlSession.selectList("listMember");
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static List<MemberDTO> findMember(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<MemberDTO> list = sqlSession.selectList("findMember", map);
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int deleteMember(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.delete("deleteMember", no);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static MemberDTO getMember(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			MemberDTO dto = sqlSession.selectOne("getMember", no);
			return dto;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int updateMember(MemberDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int res = sqlSession.update("updateMember", dto);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
}








