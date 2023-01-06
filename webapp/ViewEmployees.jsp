<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>

</head>
<body >
<h1 align="center">Employee List</h1>
<% ResultSet rs =(ResultSet)session.getAttribute("1") ; %>
<table cellpadding="4px" align="center" border="">
<th>employeeid</th>
<th>Name</th>
<th>Address</th>
<th>Gender</th>
<th>Salary</th>
<th>Birthdate</th>
<th>delete</th>


<% while(rs.next()){ %>
<tr>
<td><%= rs.getInt(1) %></td>
<td><%= rs.getString(2) %></td>
<td><%= rs.getString(3) %></td>
<td><%= rs.getInt(4) %></td>
<td><%= rs.getDouble(5) %></td>
<td><%= rs.getDate(6) %></td>
<td> <a href="deleteEmployee?id=<%=rs.getInt(1)%>">delete</a></td>
</tr>
<%} %>

</table>
</body>
</html>