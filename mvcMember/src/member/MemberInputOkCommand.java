package member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberInputOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		MemberDTO dto = new MemberDTO();
		dto.setName(req.getParameter("name"));
		dto.setId(req.getParameter("id"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setSsn1(req.getParameter("ssn1"));
		dto.setSsn2(req.getParameter("ssn2"));
		dto.setEmail(req.getParameter("email"));
		dto.setHp1(req.getParameter("hp1"));
		dto.setHp2(req.getParameter("hp2"));
		dto.setHp3(req.getParameter("hp3"));
		MemberDAO dao = new MemberDAO();
		try {
			int res = dao.insertMember(dto);
			if (res>0) {
				req.setAttribute("msg", "ȸ�����Լ���!! �α����� �� �ּ���");
				return "windowClose.jsp";
			}else {
				req.setAttribute("msg", "ȸ�����Խ���!! ȸ�������������� �̵��մϴ�.");
				req.setAttribute("url", "member_ssn.do");
			}
		}catch(SQLException e) {
			req.setAttribute("msg", "DB���� ���� �߻�!! �����ڿ��� �����ϼ���");
			return "windowClose.jsp";
		}
		return "message.jsp";
	}

}
