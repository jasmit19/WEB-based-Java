package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.service.MyLoginService;
import com.demo.service.MyLoginServiceImpl;

/**
 * Servlet implementation class MyLogin
 */
@WebServlet("/validateuser")
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		MyLoginService lservice=new MyLoginServiceImpl();
		MyUser user=lservice.validateUse(uname,pass);
		
		if(user!=null) {
			HttpSession session=request.getSession();
			
			if(session.isNew()) {
				System.out.println("new session");
				session.setMaxInactiveInterval(20000);
			}
			
			session.setAttribute("user", uname);
			RequestDispatcher rd=request.getRequestDispatcher("category");
			rd.forward(request,response);
		}
		else {
			out.println("<h3> Invalid login credentials </h3>");
			RequestDispatcher rd=request.getRequestDispatcher("MyLogin.html");
			rd.include(request, response);
		}
	}

}
