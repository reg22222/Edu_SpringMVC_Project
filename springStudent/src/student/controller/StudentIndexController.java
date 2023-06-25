package student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class StudentIndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student");
		return mav;
	}

}
/*
	ModelAndViewŬ����
	- ������
	  - ModelAndView() : ����Ʈ ������
	    -> setViewName(String) : ������������ ����
	    -> addObject(String, Object) : request��ü�� �� ����
	  - ModelAndView(String) : ������������ �����ؼ� ��ü ����
	  - ModelAndView(String, String, Object) : ������������ request�� ������ ��ü�� �����ؼ� ��ü����
*/










