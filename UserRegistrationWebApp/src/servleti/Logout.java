package servleti;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Logout extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		request.getSession().invalidate();
		request.getRequestDispatcher("kraj.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		processRequest(request, response);
	}
	
	public String getServletInfo(){
		return "Short description";
	}

}
