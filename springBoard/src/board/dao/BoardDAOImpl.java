package board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import board.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	class MyRowMapper implements RowMapper<BoardDTO>{
	@Override
		public BoardDTO mapRow(ResultSet rs, int arg1) throws SQLException {
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
			return dto;
		}
	}
	private MyRowMapper mapper = new MyRowMapper();

	@Override
	public List<BoardDTO> listBoard() {
		String sql = "select * from board order by num desc";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public BoardDTO getBoard(int num, String mode) {
		String sql = null;
		if (mode.equals("content")) {
			sql = "update board set readcount=readcount+1 where num = ?";
			jdbcTemplate.update(sql, num);
		}
		sql = "select * from board where num = ?";
		return jdbcTemplate.queryForObject(sql, mapper, num);
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		String sql = "insert into board values(board_seq.nextval,"
				+ "?,?,?,?,sysdate,0,?,?)";
		Object[] values = new Object[] {dto.getWriter(), dto.getEmail(), 
		dto.getSubject(), dto.getPasswd(), dto.getContent(), dto.getIp()};
		int res = jdbcTemplate.update(sql, values);
		return res;
	}
	
	protected boolean isPassword(int num, String passwd) {
		BoardDTO dto = getBoard(num, "password");
		if (dto.getPasswd().equals(passwd)) {
			return true;
		}
		return false;
	}

	@Override
	public int deleteBoard(int num, String passwd) {
		boolean isPass = isPassword(num, passwd);
		if (!isPass) return -1;
		String sql = "delete from board where num = ?";
		return jdbcTemplate.update(sql, num);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		boolean isPass = isPassword(dto.getNum(), dto.getPasswd());
		if (!isPass) return -1;
		String sql = "update board set writer=?, subject=?, email=?, content=? where num = ?";
		Object[] values = new Object[] 
				{dto.getWriter(), dto.getSubject(), dto.getEmail(), 
						dto.getContent(), dto.getNum()};
		return jdbcTemplate.update(sql, values);
	}

}









