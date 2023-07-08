package student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import student.dao.StudentDAO;
import student.dto.StudentDTO;
import student.mybatis.StudentMapper;

@Controller
public class StudentController {
	
	//@Autowired
	//private StudentDAO studentDAO;
	
	@RequestMapping("/student_index.do")
	public String index() {
		return "student";
	}
	//��ȯ�� : ModelAndView, Model, Map, String, View��ü, void
	
	@RequestMapping("/student_list.do")
	public String list(HttpServletRequest req) {
		//List<StudentDTO> list = studentDAO.listStudent();
		List<StudentDTO> list = StudentMapper.listStudent();
		req.setAttribute("listStudent", list);
		return "list";
	}
	
	@RequestMapping("/student_delete.do")
	public String delete(@RequestParam String id) {
		//studentDAO.deleteStudent(id);
		StudentMapper.deleteStudent(id);
		return "redirect:student_list.do";
	}
	
	@RequestMapping("/student_insert.do")
	public String insert(@ModelAttribute StudentDTO dto) {
		//studentDAO.insertStudent(dto);
		StudentMapper.insertStudent(dto);
		return "redirect:student_list.do";		
	}
	
	@RequestMapping("/student_find.do")
	public String find(HttpServletRequest req, String name) {
		//List<StudentDTO> find = studentDAO.findStudent(name);
		List<StudentDTO> find = StudentMapper.findStudent(name);
		req.setAttribute("listStudent", find);
		return "list";
	}
}














