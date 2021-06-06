package event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Change
 */
@WebServlet("/Change")
public class Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ChangeDB cd= new ChangeDB();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess= request.getSession();
		String code = request.getParameter("code");
		String pass1 = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");
		String name= sess.getAttribute("name").toString();
        if(pass1.equals(pass2)) {
        	if(cd.insert(code, pass1)) {
        		response.sendRedirect("passChange.jsp");
        		sess.removeAttribute("name");
        		sess.invalidate();
        		
        	}
        	else {
          	  response.getWriter().print("<head><body bgcolor=\"white\" style=\"font-family:tahoma; margin:auto;\"><center><h1 style=\"color:#424242;\">Something went wrong , Please try again!</h1><br/>");
          	  response.getWriter().print("<a href=\"forget.html\"><button style=\"background-color:#ff282c;color:white;padding: 1% 2%; border-radius:2em;border:0;\">Go Back</button></a></center></body></html>");

        	}
        	
        }
        else {
        	response.sendRedirect("change2.jsp");	
        }
	}

}
