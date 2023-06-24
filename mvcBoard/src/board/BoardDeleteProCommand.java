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
				req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ��� �������� �̵��մϴ�.");
				req.setAttribute("url", "board_list.do");
			}else if (res < 0) {
				req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���!!");
				req.setAttribute("url", "board_deleteForm.do?num=" + num);
			}else {
				req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ���� �������� �̵��մϴ�.");
				req.setAttribute("url", "board_content.do?num=" + num);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "�����ڿ��� ������ �ּ���!!");
			req.setAttribute("url", "board_index.do");
		}
		return "message.jsp";
	}

}
