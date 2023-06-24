package student;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentDAO;
import student.model.StudentDTO;

public class FindCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		StudentDAO dao = new StudentDAO();
		try {
			List<StudentDTO> find = dao.findStudent(name);
			req.setAttribute("listStudent", find);
			return "WEB-INF/student/list.jsp";	
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "관리자에게 문의해 주세요!!");
			req.setAttribute("url", "student.do?command=index");
			return "message.jsp";	
		}
	}

}
