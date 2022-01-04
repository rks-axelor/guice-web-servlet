<%@page import="guice.web.servlet.demo.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Inside home</h2>
<table>
<tr>
    <th>emp_id</th>
    <th>emp_name</th>
    <th>emp_sal</th>
    </tr>
    
 <% for (Employee emp : (List<Employee>)request.getAttribute("list")) { %>
		<tr>
			<td><%= emp.getEid() %></td>
			<td><%= emp.getEname() %></td>
			<td><%= emp.getEsal() %></td>
		</tr>
		<% } %>
</table>
  
</body>
</html>