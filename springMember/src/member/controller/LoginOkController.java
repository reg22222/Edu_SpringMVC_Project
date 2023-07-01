package member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class LoginOkController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		MemberDTO dto = memberDAO.getMember(id);
		ModelAndView mav = new ModelAndView();
		if (dto == null) {
			mav.addObject("msg", "���� ���̵� �Դϴ�. �ٽ� �Է��� �ּ���!!");
			mav.addObject("url", "login.do");
		}else {
			if (dto.getPasswd().equals(passwd)) {
				HttpSession session = req.getSession();
				session.setAttribute("loginMember", dto);
				Cookie ck = new Cookie("saveId", id);
				String saveId = req.getParameter("saveId");
				if (saveId == null) {
					ck.setMaxAge(0);
				}else {
					ck.setMaxAge(24*60*60);
				}
				resp.addCookie(ck);
				mav.addObject("msg", dto.getName()+"���� �α��� �Ǿ����ϴ�.");
				mav.addObject("url", "member_index.do");
			}else {
				mav.addObject("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���!!");
				mav.addObject("url", "login.do");
			}
		}
		mav.setViewName("forward:message.jsp");
		return mav;
	}

}
