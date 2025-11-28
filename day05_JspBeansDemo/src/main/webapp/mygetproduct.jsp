<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--
	int pid=Integer.parseInt(request.getParameter("proid"));
	String pname=request.getParameter("pname"));
	int qty=Integer.parseInt(request.getParameter("qty"));
	double price=Double.parseDouble(request.getParameter("price"));
	MyProduct p=new MyProduct(pid,pname,qty,price);
 --%>
 <jsp:useBean id="p" class="com.demo.beans.MyProduct"></jsp:useBean>
 <jsp:setProperty property="*" name="p"/>
 <%--
 	<jsp:setProperty name="p"  property="pid" value="<%= request.getParameter("pid")></jsp:setProperty>
 	<jsp:setProperty name="p"  property="pname" value="<%= request.getParameter("pname")></jsp:setProperty>
 	<jsp:setProperty name="p"  property="qty" value="<%= request.getParameter("qty")></jsp:setProperty>
 	<jsp:setProperty name="p"  property="price" value="<%= request.getParameter("price")></jsp:setProperty>
  --%>
  
  <h2>Product details:</h2>
  Product id:		<jsp:getProperty property="pid" name="p"/>
  Product name:		<jsp:getProperty property="pname" name="p"/>
  Product quantity:	<jsp:getProperty property="qty" name="p"/>
  Product price:	<jsp:getProperty property="price" name="p"/>
</body>
</html>