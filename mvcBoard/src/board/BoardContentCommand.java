package board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardContentCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		BoardDAO dao = new BoardDAO();
		try {
			BoardDTO dto = dao.getBoard(Integer.parseInt(num), "content");
			req.setAttribute("getBoard", dto);
			return "WEB-INF/board/content.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "�����ڿ��� ������ �ּ���!!");
			req.setAttribute("url", "board_index.do");
			return "message.jsp";
		}
	}

}
