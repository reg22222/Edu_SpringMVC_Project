package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberListController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String mode = req.getParameter("mode");
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = null;
		if (mode == null) {	//회원보기
			 list = memberDAO.listMember();
		}else {						//회원찾기
			String search = req.getParameter("search");
			String searchString = req.getParameter("searchString");
			if (search != null) {
				list = memberDAO.findMember(search, searchString);
			}
		}
		mav.addObject("listMember", list);
		mav.setViewName("memberAll");
		return mav;
	}

}
