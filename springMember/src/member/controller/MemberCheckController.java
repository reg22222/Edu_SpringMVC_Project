package member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class MemberCheckController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		
		boolean isMember = memberDAO.isCheckMember(name, ssn1, ssn2);
		ModelAndView mav = new ModelAndView();
		if (isMember) {
			mav.addObject("msg", "현재 회원이십니다. 로그인을 해 주세요!!");
			mav.setViewName("forward:windowClose.jsp");
		}else {
			mav.setViewName("member_input");
		}
		return mav;
	}

}
