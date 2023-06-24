package board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardUpdateProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		BoardDTO dto = new BoardDTO();
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content"));
		BoardDAO dao = new BoardDAO();
		try {
			int res = dao.updateBoard(dto);
			if (res > 0) {
				req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ��� �������� �̵��մϴ�.");
				req.setAttribute("url", "board_list.do");
			}else if (res < 0) {
				req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���!!");
				req.setAttribute("url", "board_updateForm.do?num=" + dto.getNum());
			}else {
				req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ���� �������� �̵��մϴ�.");
				req.setAttribute("url", "board_content.do?num=" + dto.getNum());
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "�����ڿ��� ������ �ּ���!!");
			req.setAttribute("url", "board_index.do");
		}
		return "message.jsp";
	}

}
