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
				req.setAttribute("msg", "회원삭제성공!! 회원목록페이지로 이동합니다.");
			}else {
				req.setAttribute("msg", "회원삭제실패!! 회원목록페이지로 이동합니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "DB서버 오류 발생!! 관리자에게 문의해 주세요!!");
			req.setAttribute("url", "member_index.do");
			return "message.jsp";
		}
		req.setAttribute("url", "member_list.do");
		return "message.jsp";
	}

}
