<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.domain.People" %>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% //scriptlet이라는 이름의 순수 자바 코드 개발하는 tag
// 단순 test를 위한 데이터 구성용으로만 사용 예정
request.setAttribute("rData1", "꿈이 뭐야/부자되기");
session.setAttribute("sData1", "가장 중요한 요소/가족, 건강");
session.setAttribute("sData2", "ㅇㅇㅁㄴㅇㄹ");

// ArrayList에 문자열 저장
ArrayList<String> all1 = new ArrayList<>();
all1.add("n8n");
all1.add("art&tech");
all1.add("시간 쪼개기");
all1.add("부자되기, 마음 편해지기🌟");

// ArrayList에 DTO 저장
ArrayList<People> all2 = new ArrayList<>();
all2.add(new People("연아", 30));
all2.add(new People("재석", 50));
all2.add(new People("이순신", 50));

session.setAttribute("sData3", all1);
session.setAttribute("sData4", all2);


%>
	<h3>EL tag</h3>
	
	<table border="1">
		<tr><td>non-EL</td><td>EL</td></tr>
		
		<tr><td>1+3</td><td>${1+3}</td></tr>
		<tr><td>'a' == 'a'</td><td>${'a' == 'a'}</td></tr>
		<tr><td>'a' != 'a'</td><td>${'a' != 'a'}</td></tr>
		<tr><td>50 != 50</td><td>${50 != 50}</td></tr>
		
		<tr><td>request.getAttribute("rData1")</td>
		<td>${requestScope.rData1}</td></tr>
		
		<tr><td>session.getAttribute("sData1")</td>
		<td>${sessionScope.sData1}</td></tr>
		
		<tr><td>((ArrayList<String>)session.getAttribute("sData3")).get(0)</td>
		<td>${sessionScope.sData3[0]}</td></tr>
				
		<%-- ? sData4에 저장된 연아 이름만 출력
			.name: getName() 호출 의미
		 --%>				
		<tr><td>((ArrayList<String>)session.getAttribute("sData4")).get(0).getName()</td>
		<td>${sessionScope.sData4[0].name}</td></tr>
	</table>
	<br><hr><br>
	<!-- sData4로 세션에 저장된 ArrayList의 People들의 나이를 비교하여
	age가 50인 사람의 이름과 나이값 브라우저에 출력
	deptAllView.jsp의 3단계 참조 - jstl의 forEach 활용 요청 -->
	
	<table border='1'>
	<c:forEach items="${sessionScope.sData4}" var="data">
		<c:if test="${data.age==50}"> 
		${data.name}-${data.age}<br>
		</c:if>
	</c:forEach>
	</table>
	<br><hr><br>
	<h5>데이터가 null인 경우의 EL 처리 방식</h5>
	<%
		// 로컬 변수는 선언시 자동 초기화 미진행
		String value = null; 
		out.println(value);
		//String value = "연아"; 
		//System.out.println(value.charAt(1));
		//out.println(value.charAt(1));
		
		// EL에서 브라우저에 출력을 위한 test 코드 구성
		/* 주의사항: EL 브라우저에 null인 경우 blank로 정리함
		null인 경우 출력 정보 꼼꼼하게 관리 필요
		*/
		
		request.setAttribute("rData2", value);
	%>
	<hr color="red" size="3">
	rData2가 null인 경우에는 "데이터가 없음" 출력 / 있을 경우 data 출력
	EL tag의 null값 처리 비교 학습: == / != / empty / not empty<br>
	
	
	1. 	${requestScope.rData2} <br>
	2. 	${requestScope.rData2 == null} <br>
	3. 	${empty requestScope.rData2} <br>
	4. 	${not empty requestScope.rData2} <br>
	
	<hr>
	

</body>
</html>