<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!		
	public int factorial(int n){
	int f=1;
	for(int i=2;i<n;i++){
		f=f*i;
	}
	return f;
}
%>
	<%
	String btn=request.getParameter("btn");
	int n1=Integer.parseInt(request.getParameter("n1"));
	int n2=Integer.parseInt(request.getParameter("n2"));
	
	if(btn.equals("add")){
		int ans=n1+n2;
	%>
	<h2>Addition: <%=ans%></h2>
	<%} 
	else{
		int fact=factorial(n1);
	%>
	<h2>Factorial= <%= fact %> </h2>
	<% } %>
</body>
</html>