package member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberUpdateOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		MemberDTO dto = new MemberDTO();
		dto.setNo(Integer.parseInt(req.getParameter("no")));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setEmail(req.getParameter("email"));
		dto.setHp1(req.getParameter("hp1"));
		dto.setHp2(req.getParameter("hp2"));
		dto.setHp3(req.getParameter("hp3"));
		MemberDAO dao = new MemberDAO();
		try {
			int res = dao.updateMember(dto);
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
