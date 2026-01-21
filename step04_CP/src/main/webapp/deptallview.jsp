<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.domain.DeptDTO" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	System.out.println("jsp 실행 시작");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<!-- http://ip:port/context/DeptAllView.jsp -->

<h3>Step01</h3>
<%	 //step01 
		ArrayList<DeptDTO> datas = (ArrayList<DeptDTO>)request.getAttribute("depts");
		
		out.println("<table border='1'>");
		out.println("<tr><th>부서번호</th><th>부서명</th><th>지역</th></tr>");
		
		for(DeptDTO dept : datas) {
			out.println("<tr>");
			
			out.println("<td>" + dept.getDeptno() + "</td>");
			out.println("<td>" + dept.getDname() + "</td>");
			out.println("<td>" + dept.getLoc() + "</td>");
			
			out.println("</tr>");
		}
		
		out.println("</table>");
%>

<br><hr><br>
<h3>Step02</h3>
<%	 
	datas = (ArrayList<DeptDTO>)request.getAttribute("depts");
%>	
	<table border='1'>
	<tr><th>부서번호</th><th>부서명</th><th>지역</th></tr>
<%	
	for(DeptDTO dept : datas) {
%>		
		<tr>
		<td><%=dept.getDeptno() %> </td>
		<td><%=dept.getDname() %></td>
		<td><%=dept.getLoc() %></td>
		
		</tr>
<%	
	}
%>
	</table>

<br><hr><br>
<h3>Step03 - EL & JSTL</h3>

	<table border='1'>
	<tr><th>부서번호</th><th>부서명</th><th>지역</th></tr>
	
	<c:forEach items="${requestScope.depts}" var="data">
		<tr>
			<td>${data.deptno}</td>
			<td>${data.dname}</td>
			<td>${data.loc}</td>
		
		</tr>
	</c:forEach>
	

	</table>










</body>
</html>