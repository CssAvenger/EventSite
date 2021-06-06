package event;

import java.io.IOException;
import java.util.Random;
import java.lang.Math;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Forget")
public class Forget extends HttpServlet {
    Forgetdb fd= new Forgetdb();
	private static final long serialVersionUID = 1L;
	String id;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          HttpSession sess= request.getSession();
   		  String email = request.getParameter("email");

          if (fd.change(email)) {
        	  
       	String str=fd.id(email); 
      	 id=str.substring(0,10);
      	String name= str.substring(11);
      	MissMail.send(id, name,email);
      	sess.setAttribute("name", name);
      	RequestDispatcher rd= request.getRequestDispatcher("change.jsp");
      	rd.forward(request, response);
         }   
          else {
        	  response.getWriter().print("<head><body bgcolor=\"white\" style=\"font-family:tahoma; margin:auto;\"><center><h1 style=\"color:#424242;\">No email found try again!</h1><br/>");
        	  response.getWriter().print("<a href=\"change.jsp\"><button style=\"background-color:#ff282c;color:white;padding: 1% 2%; border-radius:2em;border:0;\">Go Back</button></a></center></body></html>");

          }
   		
}

}
