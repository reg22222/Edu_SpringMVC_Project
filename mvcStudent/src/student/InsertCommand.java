package student;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentDAO;
import student.model.StudentDTO;

public class InsertCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		StudentDTO dto = new StudentDTO();
		dto.setId(req.getParameter("id"));
		dto.setName(req.getParameter("name"));
		dto.setCname(req.getParameter("cname"));
		StudentDAO dao = new StudentDAO();
		try{
			int res = dao.insertStudent(dto);
			if (res>0) {
				req.setAttribute("msg", "학생등록성공!! 학생목록페이지로 이동합니다.");
				req.setAttribute("url", "student.do?command=list");
			}else {
				req.setAttribute("msg", "학생등록실패!! 학생관리페이지로 이동합니다.");
				req.setAttribute("url", "student.do?command=index");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "관리자에게 문의해 주세요!!");
			req.setAttribute("url", "student.do?command=index");
		}
		return "message.jsp";
	}

}
