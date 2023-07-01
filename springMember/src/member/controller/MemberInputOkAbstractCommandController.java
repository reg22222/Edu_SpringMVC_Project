package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberInputOkAbstractCommandController extends AbstractCommandController {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest req, 
			HttpServletResponse resp, Object arg2, BindException arg3)
			throws Exception {
		MemberDTO dto = (MemberDTO)arg2;
		int res = memberDAO.insertMember(dto);
		ModelAndView mav = new ModelAndView();
		if (res>0) {
			mav.addObject("msg", "ȸ�����Լ���!! �α����� �� �ּ���");
			mav.setViewName("forward:windowClose.jsp");
		}else {
			mav.addObject("msg", "ȸ�����Խ���!! �ٽ� �Է��� �ּ���");
			mav.addObject("url", "member_ssn.do");
			mav.setViewName("forward:message.jsp");
		}
		return mav;
	}

}
