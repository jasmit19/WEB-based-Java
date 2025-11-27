package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("nm");
		String val=request.getParameter("val");
		String button=request.getParameter("btn");
		
		switch(button) {
		case "add"-> {
			Cookie c=new Cookie(name,val);
			response.addCookie(c);
			out.println("<h2> Cookie added <h2/>");
			break;
		}
		
		case "delete"->{
			Cookie[] carr=request.getCookies();
			
			//for each loop to iterate through all cookies fetched
			for(Cookie c:carr) {
				//check the cookie name to be deleted
				if(c.getValue().equals(val)){
					//immediately delete cookie if found
					c.setMaxAge(0);
					response.addCookie(c);
					out.println("<h3> "+name+"Cookie deleted <h3/>");
				}
				else {
					out.println("<h3> Invalid cookie <h3/>");
				}
			}
			break;
		}
		
		case "display" ->{
			Cookie[] carr=request.getCookies();
			//List<Cookie> clist=new ArrayList<>();

			for(Cookie c:carr) {
				out.println("name:"+c.getName()+" ---> "+"value:"+c.getValue());
			}
		}
		}
		
		//fetches a dispatcher object that points to the HTML page in Web App CookieServlet.html
		RequestDispatcher rd=request.getRequestDispatcher("CookieServlet.html");
		//tells the servlet container to include output of HTML file into the current response
		rd.include(request, response);
	}
	
	
	//So the sequence is:
	//1. Your servlet executes the cookie logic (add/delete/display).
	//2. It writes some dynamic output with out.println(...).
	//3. Then it includes the content of CookieServlet.html right after that dynamic output.
	//4. The final response sent to the browser is a combination of both.

}
