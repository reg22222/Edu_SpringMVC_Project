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
				req.setAttribute("msg", "�л���������!! �л������������ �̵��մϴ�.");
				req.setAttribute("url", "student.do?command=list");
			}else {
				req.setAttribute("msg", "�л���������!! �л������������� �̵��մϴ�.");
				req.setAttribute("url", "student.do?command=index");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "�����ڿ��� ������ �ּ���!!");
			req.setAttribute("url", "student.do?command=index");
		}
		return "message.jsp";
	}

}
