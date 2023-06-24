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
				req.setAttribute("msg", "�л���ϼ���!! �л������������ �̵��մϴ�.");
				req.setAttribute("url", "student.do?command=list");
			}else {
				req.setAttribute("msg", "�л���Ͻ���!! �л������������� �̵��մϴ�.");
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
