package board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;

public class BoardDeleteProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		String passwd = req.getParameter("passwd");
		BoardDAO dao = new BoardDAO();
		try {
			int res = dao.deleteBoard(Integer.parseInt(num), passwd);
			if (res > 0) {
				req.setAttribute("msg", "게시글 삭제 성공!! 게시글 목록 페이지로 이동합니다.");
				req.setAttribute("url", "board_list.do");
			}else if (res < 0) {
				req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!!");
				req.setAttribute("url", "board_deleteForm.do?num=" + num);
			}else {
				req.setAttribute("msg", "게시글 삭제 실패!! 게시글 보기 페이지로 이동합니다.");
				req.setAttribute("url", "board_content.do?num=" + num);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "관리자에게 문의해 주세요!!");
			req.setAttribute("url", "board_index.do");
		}
		return "message.jsp";
	}

}
