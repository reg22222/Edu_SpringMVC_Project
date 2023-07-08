package member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.dto.MemberDTO;
import member.mybatis.MemberMapper;

@Controller
public class MemberController {

	@RequestMapping("/member_index.do")
	public String member_index() {
		return "member_index";
	}
	
	@RequestMapping("/member_ssn.do")
	public String member_ssn() {
		return "memberSsn";
	}
	
	@RequestMapping("/member_check.do")
	public String member_check(HttpServletRequest req, @RequestParam Map<String, String> map) {
		boolean isMember = MemberMapper.isCheckMember(map);
		if (isMember) {
			req.setAttribute("msg", "현재 회원이십니다. 로그인을 해 주세요!!");
			return "forward:windowClose.jsp";
		}else {
			return "member_input";
		}
	}
	
	@RequestMapping("/member_input_ok.do")
	public String member_input(HttpServletRequest req, @ModelAttribute MemberDTO dto) {
		int res = MemberMapper.insertMember(dto);
		if (res>0) {
			req.setAttribute("msg", "회원가입성공!! 로그인을 해 주세요");
			return "forward:windowClose.jsp";
		}else {
			req.setAttribute("msg", "회원가입실패!! 다시 입력해 주세요");
			req.setAttribute("url", "member_ssn.do");
			return "forward:message.jsp";
		}
	}
	
	@RequestMapping("/member_list.do")
	public String member_list(HttpServletRequest req, @RequestParam Map<String, String> map) {
		List<MemberDTO> list = null;
		if (map == null || map.size() == 0) {	
			 list = MemberMapper.listMember();
		}else {
			if (map.containsKey("search")) {
				list = MemberMapper.findMember(map);
			}
		}
		req.setAttribute("listMember", list);
		return "memberAll";
	}
	
	@RequestMapping("/member_delete.do")
	public String member_delete(HttpServletRequest req, int no) {
		int res = MemberMapper.deleteMember(no);
		if (res>0) {
			req.setAttribute("msg", "회원삭제 성공!! 회원목록페이지로 이동합니다.");
		}else {
			req.setAttribute("msg", "회원삭제 실패!! 회원목록페이지로 이동합니다.");
		}
		req.setAttribute("url", "member_list.do");
		return "forward:message.jsp";
	}
	
	@RequestMapping(value="/member_update.do", method=RequestMethod.GET)
	public String member_update(HttpServletRequest req, int no) {
		MemberDTO dto = MemberMapper.getMember(no);
		req.setAttribute("getMember", dto);
		return "member_edit";
	}
	
	@RequestMapping(value="/member_update_ok.do", method=RequestMethod.POST)
	public String member_update_ok(HttpServletRequest req, MemberDTO dto) {
		int res = MemberMapper.updateMember(dto);
		if (res>0) {
			req.setAttribute("msg", "회원수정 성공!! 회원목록페이지로 이동합니다.");
		}else {
			req.setAttribute("msg", "회원수정 실패!! 회원목록페이지로 이동합니다.");
		}
		req.setAttribute("url", "member_list.do");
		return "forward:message.jsp";
	}
}















