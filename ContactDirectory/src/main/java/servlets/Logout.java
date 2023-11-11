
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
		
		@Override
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			HttpSession session = request.getSession();
			System.out.println("welcome to logout!!");
			Cookie ck = new Cookie("auth","username");
			ck.setMaxAge(0); // removing cookie by making age is 0
			response.addCookie(ck);
			response.sendRedirect("login.jsp");
		}
}
