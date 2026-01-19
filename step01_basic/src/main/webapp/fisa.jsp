<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%-- jsp 주석 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ㅎ ㅏ ㄴ ㄱ ㅡ ㄹ
	한글
</body>
</html>

<!--
	http://ip:port/step01_basic/fisa.jsp 
 -->
 
 <%-- jsp 상단 코드
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
질문: page 지시자와 jsp만의 주석이 실행되는 곳?
	tomcat(web container, servlet engine)
	브라우저로 미 전송, 소스 보기로 확인 불가
	보안을 고려한 내용의 경우 jsp주석으로 처리
	
질문2: html,css,JS는 tomcat 관점에서 순수 문자열로 인식? 실행 소스로 인식?
	network 통해서 브라우저 문자열로 응답 후 브라우저는 각 언어로 구분 후 설명
	브라우저 내에는 html 해석 실행기, css 해석 실행기, js 해석 실행기 내장

 
 
 --%>
 