package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyProduct;
import com.demo.service.MyProductService;
import com.demo.service.MyProductServiceImpl;

public class MyShowProduct extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		MyProductService pservice=new MyProductServiceImpl();
		List<MyProduct> plist=pservice.getAllProducts();
		
		out.println("<table border='2'><tr> <th>ID</th> <th>NAME</th> <th>QUANTITY</th> <th>PRICE</th> <th>EXP DATE</th> <th>CID</th> <th>ACTION</th> </tr>")
		for(MyProduct p:plist) {
			out.println("<tr>	<td>"+p.getPid()+"</td>	<td>"+p.getPname()+"</td>	<td>"+p.getQty()+"</td>	<td>"+p.getPrice()+"</td>	<td>"+p.getExpdate()+"</td> </tr>");
			out.println("<tr><td><a href='deleteProduct?pid="+p.getPid()+"'>delete</a></td>		<td><a href='editProduct?pid="+p.getPid()+"'>edit</a></td>	</tr>");
		}
		out.println("</table>");
		out.println("<a href='addProduct.html'>Add new product<a/>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
}
