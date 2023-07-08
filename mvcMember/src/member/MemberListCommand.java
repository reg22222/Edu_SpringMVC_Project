package member;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String mode = req.getParameter("mode");
		
		MemberDAO dao = new MemberDAO();
		try {
			List<MemberDTO> list = null;
			if (mode == null) {
				list = dao.listMember();
			}else {
				String search = req.getParameter("search");
				String searchString = req.getParameter("searchString");
				if (search == null) list = null;
				else list = dao.findMember(search, searchString);
			}
			req.setAttribute("listMember", list);
			return "WEB-INF/member/memberAll.jsp";
			
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "DB서버 오류 발생!! 관리자에게 문의해 주세요");
			req.setAttribute("url", "member_index.do");
			return "message.jsp";
		}
	}
}
