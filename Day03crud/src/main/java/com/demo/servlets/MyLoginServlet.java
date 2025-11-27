package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.service.MyLoginService;
import com.demo.service.MyLoginServiceimpl;


public class MyLoginServlet extends HttpServlet{
	
	//throws IOException
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		MyLoginService lservice=new MyLoginServiceimpl();
		MyUser user=lservice.validateUser(uname,pass);
		
		if(user!=null) {
			RequestDispatcher rd=request.getRequestDispatcher("showproduct");
			rd.forward(request,response);
		}
		else {
			out.println("invalid credentials");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
		
	}
}
