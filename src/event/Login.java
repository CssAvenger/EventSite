package event;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CompanyInfo comp= new CompanyInfo();
	LoginDB db= new LoginDB();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1= request.getParameter("username");
		String s2= request.getParameter("password");
		String name= comp.nameCheck(s1);
		String cat= comp.org(s1);
		HttpSession hs= request.getSession();
		
		if(db.check(s1, s2)) {
		response.sendRedirect("dashboard.jsp");
		hs.setAttribute("compName", name);
		hs.setAttribute("Email", s1);
		hs.setAttribute("category", cat);
		}
		else {
	    response.sendRedirect("wrongLogin.jsp");
		}
		
	
	}

}
