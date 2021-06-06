package event;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/VerifyOTP")
public class VerifyOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String otp=(String)session.getAttribute("otp");
		String code= request.getParameter("code");
		if(code.contentEquals(otp)) {
		 session.removeAttribute("otp");
		 session.invalidate();
		 response.sendRedirect("Finally.jsp");
		}
		else {
			response.sendRedirect("WrongOTP.jsp");
		}
	}
    
}
