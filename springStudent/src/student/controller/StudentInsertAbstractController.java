package student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.AbstractController;

import student.dao.StudentDAO;
import student.dto.StudentDTO;

public class StudentInsertAbstractController extends AbstractCommandController{
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest req,
			HttpServletResponse resp, Object arg2, BindException arg3)
			throws Exception {
		StudentDTO dto = (StudentDTO)arg2;
		int res = studentDAO.insertStudent(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:student_list.do");
		return mav;
	}

}









