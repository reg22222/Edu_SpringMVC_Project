package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;

public class BoardDeleteProController implements Controller {
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int num = ServletRequestUtils.getIntParameter(req, "num");
		String passwd = req.getParameter("passwd");
		int res = boardDAO.deleteBoard(num, passwd);
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		if (res > 0) {
			mav.addObject("msg", "게시글 삭제 성공!! 게시글 목록 페이지로 이동합니다.");
			mav.addObject("url", "board_list.do");
		}else if (res < 0) {
			mav.addObject("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!!");
			mav.addObject("url", "board_deleteForm.do?num=" + num);
		}else {
			mav.addObject("msg", "게시글 삭제 실패!! 게시글 보기 페이지로 이동합니다.");
			mav.addObject("url", "board_content.do?num=" + num);
		}
		return mav;
	}

}
