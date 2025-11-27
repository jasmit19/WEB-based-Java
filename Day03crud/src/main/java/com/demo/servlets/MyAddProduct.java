package com.demo.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyProduct;
import com.demo.service.MyProductService;
import com.demo.service.MyProductServiceImpl;

public class MyAddProduct extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		String pname=req.getParameter("pname");
		int qty=Integer.parseInt(req.getParameter("pname"));
		double price=Double.parseDouble(req.getParameter("price"));
		String dt=req.getParameter("expdate");
		LocalDate ldt=LocalDate.parse(dt, DateTimeFormatter.ofPattern("dd-mm-yyyy"));
		int cid=Integer.parseInt(req.getParameter("cid"));
		MyProduct p=new MyProduct(pid,pname,qty,price,ldt,cid);
		MyProductService pservice=new MyProductServiceImpl();
		boolean status=pservice.addNewProduct(p);
	}
	
}
