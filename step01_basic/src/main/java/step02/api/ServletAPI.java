package step02.api;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* client 요청, 응답 하나의 파일 처리 
 * 1. 요청시: 입력 데이터(한글)
 * 2. 응답시: 브라우저로 응답(tomcat 관점에선 문자열)
 * 
 */
//http://ip:port/step02_basic/api : get 방식
@WebServlet("/api")
public class ServletAPI extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletAPI doGet()");
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletAPI doPost()");
		process(request, response);
	}
	// 방식과 무관하게 공통로직 개발하는 사용자 정의 메소드
	protected void process(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("name"));
		
		// client에게 응답하는 포맷(mime type) 설정
		// client 브라우저에게 응답
		// 접속한 client에게 응답하는 출력 객체
		
		
		response.setContentType("text/html;charsert=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(request.getParameter("name"));
		out.println("<hr>");
		
		out.println("<hr>");
		out.println("<img src='images/Gemini_Generated_Image_uid27xuid27xuid2.png'/>");
		
		out.close();
		
	}

}
