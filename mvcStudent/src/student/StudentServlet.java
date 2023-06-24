package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
						HttpServletResponse resp) 
					throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		
		PrintWriter pw = resp.getWriter();
		//pw.println("여기오면 성공!!");
		
		String cmd = req.getParameter("command");
		
		CommandFactory factory = CommandFactory.getinstance();
		CommandIf cmdIf = factory.createCommand(cmd);
		String nextPage = (String)cmdIf.processCommand(req, resp);			
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
}














