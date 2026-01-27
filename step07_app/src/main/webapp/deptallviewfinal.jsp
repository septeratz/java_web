<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div class="w3-modal-content">
			<div class="w3-container">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="w3-button w3-display-topright" style="color: blue;">&times;</span>
					
				<h4 class="w3-center" style="color:black;">모든 부서 정보</h4>
				<br>
				
				<table border="1">
					<c:forEach items="${requestScope.depts}" var="dept">
						<tr>
							<td>${dept.deptno}</td>
							<td>${dept.dname}</td>
							<td>${dept.loc}</td>
						</tr>
					</c:forEach>
				</table>	

				<p />
             </div>
         </div>