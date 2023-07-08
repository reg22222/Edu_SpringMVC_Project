package board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.mybatis.BoardMapper;

@Controller
public class BoardController {
	
	//@Autowired
	//private BoardDAO boardDAO;
	
	@RequestMapping("/board_list.do")
	public ModelAndView listBoard() {
		//List<BoardDTO> list = boardDAO.listBoard();
		List<BoardDTO> list = BoardMapper.listBoard();
		return new ModelAndView("list", "listBoard", list);
	}
	
	@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping(value="/board_write.do", method=RequestMethod.POST)
	public String writePro(HttpServletRequest req, @ModelAttribute BoardDTO dto) {
		//int res = boardDAO.insertBoard(dto);
		int res = BoardMapper.insertBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "�Խñ� ��� ����!! �Խñ� ����������� �̵��մϴ�.");
			req.setAttribute("url", "board_list.do");
		}else {
			req.setAttribute("msg", "�Խñ� ��� ����!! �Խñ� ����������� �̵��մϴ�.");
			req.setAttribute("url", "board_writeForm.do");
		}
		return "forward:message.jsp";
	}
	
	@RequestMapping("/board_content.do")
	public String content(HttpServletRequest req, int num) {
		//BoardDTO dto = boardDAO.getBoard(num, "content");
		BoardDTO dto = BoardMapper.getBoard(num, "content");
		req.setAttribute("getBoard", dto);
		return "content";
	}
	
	@RequestMapping(value="/board_delete.do", method=RequestMethod.GET)
	public String deleteForm() {
		return "deleteForm";
	}
	
	@RequestMapping(value="/board_delete.do", method=RequestMethod.POST)
	public String deletePro(HttpServletRequest req, 
							@RequestParam Map<String, String> map) {
		//int res = boardDAO.deleteBoard
		//			(Integer.parseInt(map.get("num")), map.get("passwd"));
		int res = BoardMapper.deleteBoard(map);
		if (res>0) {
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ����������� �̵��մϴ�.");
			req.setAttribute("url", "board_list.do");
		}else if (res==0){
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ���������� �̵��մϴ�.");
			req.setAttribute("url", "board_content.do?num=" + map.get("num"));
		}else {
			req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���");
			req.setAttribute("url", "board_delete.do?num=" + map.get("num"));
		}
		return "forward:message.jsp";
	}
	
	@RequestMapping(value="/board_update.do", method=RequestMethod.GET)
	public String updateForm(HttpServletRequest req, int num) {
		//BoardDTO dto = boardDAO.getBoard(num, "update");
		BoardDTO dto = BoardMapper.getBoard(num, "update");
		req.setAttribute("getBoard", dto);
		return "updateForm";
	}
	
	@RequestMapping(value="/board_update.do", method=RequestMethod.POST)
	public String updatePro(HttpServletRequest req, 
												@ModelAttribute BoardDTO dto) {
		//int res = boardDAO.updateBoard(dto);
		int res = BoardMapper.updateBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ����������� �̵��մϴ�.");
			req.setAttribute("url", "board_list.do");
		}else if (res==0){
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ���������� �̵��մϴ�.");
			req.setAttribute("url", "board_content.do?num=" + dto.getNum());
		}else {
			req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���");
			req.setAttribute("url", "board_update.do?num=" + dto.getNum());
		}
		return "forward:message.jsp";
	}
}












