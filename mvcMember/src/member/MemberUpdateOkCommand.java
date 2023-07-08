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
				req.setAttribute("msg", "회원수정성공!! 회원목록페이지로 이동합니다.");
			}else {
				req.setAttribute("msg", "회원수정실패!! 회원목록페이지로 이동합니다.");
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
