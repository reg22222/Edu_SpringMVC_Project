package student;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentDAO;

public class DeleteCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		StudentDAO dao = new StudentDAO();
		try {
			int res = dao.deleteStudent(id);
			if (res>0) {
				req.setAttribute("msg", "학생삭제성공!! 학생목록페이지로 이동합니다.");
				req.setAttribute("url", "student.do?command=list");
			}else {
				req.setAttribute("msg", "학생삭제실패!! 학생관리페이지로 이동합니다.");
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
