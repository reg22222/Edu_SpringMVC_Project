package board;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		BoardDAO dao = new BoardDAO();
		try {
			List<BoardDTO> list = dao.listBoard();
			req.setAttribute("listBoard", list);
			return "WEB-INF/board/list.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "관리자에게 문의해 주세요!!");
			req.setAttribute("url", "board_index.do");
			return "message.jsp";	
		}
	}

}
