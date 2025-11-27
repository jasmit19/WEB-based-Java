package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet1 implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("nm");
		
		out.println("<form action='Servlet2'  method='get' ");
		
		out.println("Location: <input	type='text' name='location' id='location'	/><br/>");
		out.println(" <input	type='hidden'	name='nm'	id='nm'   value='"+name+"'/><br/>");
		out.println("<button type='submit' name='btn' id='btn' ></button><br/>");
		
		out.println("</form>");
	}
	
}
