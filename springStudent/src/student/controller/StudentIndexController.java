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
	ModelAndView클래스
	- 생성자
	  - ModelAndView() : 디폴트 생성자
	    -> setViewName(String) : 다음페이지를 지정
	    -> addObject(String, Object) : request객체에 값 지정
	  - ModelAndView(String) : 다음페이지를 지정해서 객체 생성
	  - ModelAndView(String, String, Object) : 다음페이지와 request에 저장할 객체를 지정해서 객체생성
*/










