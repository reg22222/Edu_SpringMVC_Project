package student;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentDAO;
import student.model.StudentDTO;

public class ListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		StudentDAO dao = new StudentDAO();
		try {
			List<StudentDTO> list = dao.listStudent();
			req.setAttribute("listStudent", list);
			return "WEB-INF/student/list.jsp";	
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "관리자에게 문의해 주세요!!");
			req.setAttribute("url", "student.do?command=index");
			return "message.jsp";	
		}
	}

}
