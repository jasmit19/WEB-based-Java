package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.service.MyProductSerive;
import com.demo.service.MyProductServiceImpl;

/**
 * Servlet implementation class MyCategoryServlet
 */
@WebServlet("/category")
public class MyCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//check user exists in the session
		HttpSession session=request.getSession();
		MyUser user=(MyUser) session.getAttribute("uname");
		
		if(user!=null && user.getRole().equals("user")) {
			MyProductSerive pservice=new MyProductServiceImpl();
			List<Integer> cl=pservice.getAllCategory();
			
			out.println("<form action='showproduct' <select name='category'>");
			for(int i:cl) {
				out.println("<option value='"+i+"'>"+i+"</option>");
			}
			out.println("</select>");
			out.println("<button type='submit' name='btn' id='btn' value='show'>Submit</button>");
			out.println("<button type='submit' name='btn' id='btn' value='order'>Placeorder</button>");
			out.println("</form>");
			out.println("<a href='logout'>Logout</a>");
		}
		else {
			out.println("<h3> Unauthorized access </h3>");
			RequestDispatcher rd=request.getRequestDispatcher("MyLogin.html");
			rd.include(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	

}
