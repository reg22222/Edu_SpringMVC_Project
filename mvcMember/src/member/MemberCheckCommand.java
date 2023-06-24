package member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberDAO;

public class MemberCheckCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		MemberDAO dao = new MemberDAO();
		try {
			boolean isMember = dao.isCheckMember(name, ssn1, ssn2);
			if (isMember) {
				req.setAttribute("msg", "�̹� ȸ���̽ʴϴ�. �α����� �� �ּ���!!");
				return "windowClose.jsp";
			}else {
				HttpSession session = req.getSession();
				session.setAttribute("name", name);
				session.setAttribute("ssn1", ssn1);
				session.setAttribute("ssn2", ssn2);
				req.setAttribute("msg", "ȸ�������������� �̵��մϴ�.");
				req.setAttribute("url", "member_input.do");
				return "message.jsp";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "DB ���� ���� �߻�!! �����ڿ��� ������ �ּ���");
			return "windowClose.jsp";
		}
	}

}
