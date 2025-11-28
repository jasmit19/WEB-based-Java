package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.service.MyLoginService;
import com.demo.service.MyLoginServiceImpl;

/**
 * Servlet implementation class MyLoginServlet
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
		MyUser user=lservice.validateUser(uname,pass);
		
		if(user!=null) {
			RequestDispatcher rd=request.getRequestDispatcher("showproduct");
			rd.forward(request, response);
		}
		else {
			out.println("<h2> Invalid credentials </h2>");
			RequestDispatcher rd=request.getRequestDispatcher("mylogin.jsp");
			// login.jsp or login.html ??
			rd.include(request, response);
		}
	}

}
