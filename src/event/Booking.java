package event;

import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.*;
 import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Booking")
public class Booking extends HttpServlet {
	//random code method 
	String getAlphaNumericString() 
	    { 
		 int n=5;
	  
	        // chose a Character random from this String 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"; 
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    } 
	String bookCode= "BOOK-"+ getAlphaNumericString();
		
	private static final long serialVersionUID = 1L;
       BookDB book= new BookDB();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pr = response.getWriter();
		String dist= request.getParameter("Delhi");
		String area= request.getParameter("Area");
		String occassion= request.getParameter("occasion");
		String guest= request.getParameter("people");
		String pack= request.getParameter("package");
		String budget= request.getParameter("budget");
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String phone= request.getParameter("number");
		String date= request.getParameter("date");
       
		
		if(book.insert(dist, area, occassion, guest, pack, budget, name, email, phone, date , bookCode)) {
		    request.setAttribute("name",name);
		    SendMail.send(email,name, bookCode);
			request.getRequestDispatcher("yeah.jsp").forward(request, response);
		}
		else {
			pr.print("<html><body><center><h1>Something went wrong please Go Back and try again!!</h1></center></body></html>");
		}
	}

}
