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
			mav.addObject("msg", "�Խñ� ���� ����!! �Խñ� ��� �������� �̵��մϴ�.");
			mav.addObject("url", "board_list.do");
		}else if (res < 0) {
			mav.addObject("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���!!");
			mav.addObject("url", "board_updateForm.do?num=" + dto.getNum());
		}else {
			mav.addObject("msg", "�Խñ� ���� ����!! �Խñ� ���� �������� �̵��մϴ�.");
			mav.addObject("url", "board_content.do?num=" + dto.getNum());
		}
		return mav;
	}

}
