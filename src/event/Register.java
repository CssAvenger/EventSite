package event;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	RegDB db= new RegDB();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pr = response.getWriter();
		String compName=request.getParameter("compName").toString();  
		String email=request.getParameter("email").toString();  
		String category=request.getParameter("category").toString();  
		String pass=request.getParameter("password").toString();  
		HttpSession session= request.getSession();
		int i = (int)Math.floor(10000*Math.random());
		String otp= ""+i;
		session.setAttribute("otp", otp);
		if(db.insert(compName, email, category, pass)) {
			SignMail.send(email, compName, otp);
			response.sendRedirect("welcome.jsp");
		}
		else {
			pr.print("<html><body><h1 style=\"text-align:center; color:#424242\">Try again!</h1>");
					pr.print("<button style=\"margin:auto; background:tomato color:white; padding:5px 20px;\"></body></html>");

		}
	}

}
