package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogOutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "�α׾ƿ� �Ǿ����ϴ�.");
		mav.addObject("url", "member_index.jsp");
		return mav;
	}

}
