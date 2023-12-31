package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardUpdateProAbstractCommandController extends AbstractCommandController {
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object arg2, BindException arg3)
			throws Exception {
		BoardDTO dto = (BoardDTO)arg2;
		int res = boardDAO.updateBoard(dto);
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		if (res > 0) {
			mav.addObject("msg", "게시글 수정 성공!! 게시글 목록 페이지로 이동합니다.");
			mav.addObject("url", "board_list.do");
		}else if (res < 0) {
			mav.addObject("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!!");
			mav.addObject("url", "board_updateForm.do?num=" + dto.getNum());
		}else {
			mav.addObject("msg", "게시글 수정 실패!! 게시글 보기 페이지로 이동합니다.");
			mav.addObject("url", "board_content.do?num=" + dto.getNum());
		}
		return mav;
	}

}
