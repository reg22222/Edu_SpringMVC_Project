package member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberUpdateCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String no = req.getParameter("no");
		MemberDAO dao = new MemberDAO();
		try {
			MemberDTO dto = dao.getMember(Integer.parseInt(no));
			req.setAttribute("getMember", dto);
			return "WEB-INF/member/member_edit.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "DB���� ���� �߻�!! �����ڿ��� ������ �ּ���!!");
			req.setAttribute("url", "member_index.do");
			return "message.jsp";
		}
		
	}

}
