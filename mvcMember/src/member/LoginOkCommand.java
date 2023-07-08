package member;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class LoginOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		MemberDAO dao = new MemberDAO();
		try {
			MemberDTO dto = dao.getMember(id);
			if (dto == null) {
				req.setAttribute("msg", "없는 아이디 입니다. 다시 확인해 주세요");
				req.setAttribute("url", "login.do");
			}else if (!dto.getPasswd().equals(passwd)) {
				req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 확인해 주세요");
				req.setAttribute("url", "login.do");
			}else {
				Cookie ck = new Cookie("saveId", dto.getId());
				String saveId = req.getParameter("saveId");
				if(saveId == null) {
					ck.setMaxAge(0);
				}else {
					ck.setMaxAge(24*60*60);
				}
				resp.addCookie(ck);
				HttpSession session = req.getSession();
				session.setAttribute("loginMember", dto);
				req.setAttribute("msg", dto.getName()+"님이 로그인 되었습니다.");
				req.setAttribute("url", "member_index.do");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "DB서버 오류 발생!! 관리자에게 문의해 주세요");
			req.setAttribute("url", "member_index.do");
		}
		return "message.jsp";
	}

}








