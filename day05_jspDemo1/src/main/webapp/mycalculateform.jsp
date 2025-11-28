<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="myheader.html" %>
<form action='myresultform.jsp'>
	Num 1: <input type='text' name='n1' id='n1' /><br/>
	Num 2: <input type='text' name='n2' id='n2' /><br/>
	<button type='submit' name='btn' id='btn' value='add'>Addition</button>
	<button type='submit' name='btn' id='btn' value='fact'>Factorial</button>
	<%@include file="myfooter.html" %>
</form>

</body>
</html>