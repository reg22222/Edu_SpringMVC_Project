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
				req.setAttribute("msg", "회원가입성공!! 로그인을 해 주세요");
				return "windowClose.jsp";
			}else {
				req.setAttribute("msg", "회원가입실패!! 회원가입페이지로 이동합니다.");
				req.setAttribute("url", "member_ssn.do");
			}
		}catch(SQLException e) {
			req.setAttribute("msg", "DB서버 오류 발생!! 관리자에게 문의하세요");
			return "windowClose.jsp";
		}
		return "message.jsp";
	}

}
