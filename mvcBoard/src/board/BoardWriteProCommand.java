package board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardWriteProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		BoardDTO dto = new BoardDTO();
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content"));
		dto.setIp(req.getRemoteAddr());
		BoardDAO dao = new BoardDAO();
		try {
			int res = dao.insertBoard(dto);
			if (res>0) {
				req.setAttribute("msg", "�Խñ۵�ϼ���!! �Խñ۸���������� �̵��մϴ�.");
				req.setAttribute("url", "board_list.do");
			}else {
				req.setAttribute("msg", "�Խñ۵�Ͻ���!! �Խñ۵���������� �̵��մϴ�.");
				req.setAttribute("url", "board_writeForm.do");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "�����ڿ��� ������ �ּ���!!");
			req.setAttribute("url", "board_index.do");
		}
		return "message.jsp";

	}

}
