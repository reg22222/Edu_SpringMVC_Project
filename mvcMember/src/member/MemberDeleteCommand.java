package member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;

public class MemberDeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String no = req.getParameter("no");
		MemberDAO dao = new MemberDAO();
		try {
			int res = dao.deleteMember(Integer.parseInt(no));
			if (res>0) {
				req.setAttribute("msg", "ȸ����������!! ȸ������������� �̵��մϴ�.");
			}else {
				req.setAttribute("msg", "ȸ����������!! ȸ������������� �̵��մϴ�.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "DB���� ���� �߻�!! �����ڿ��� ������ �ּ���!!");
			req.setAttribute("url", "member_index.do");
			return "message.jsp";
		}
		req.setAttribute("url", "member_list.do");
		return "message.jsp";
	}

}
