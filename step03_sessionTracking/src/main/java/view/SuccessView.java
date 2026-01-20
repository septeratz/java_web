package view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/succ")
public class SuccessView extends HttpServlet {

	protected void SuccessView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("successview SuccessView()");
		process(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("successview doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("successview doPost()");
		process(request, response);
	}

	// 방식과 무관하게 공통로직 개발하는 사용자 정의 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		out.println(request.getParameter("id") + "님의 이름은?<br>");
//		out.println(request.getAttribute("name") + "시죠? 반갑습니다");
		
		out.println("<hr>");
		
		/* 1. 세션
		 * 이미 존재하는 세션 데이터를 공유받아와야 함
		 * 세션에 이미 저장된 데이터값 획득 및 활용
		 * 
		 */
//		HttpSession session = request.getSession(); // 공유받는 객체
//		out.println("세션 데이터: " + session.getId());
//		out.println(session.getAttribute("id"));
//		out.println("<br>");
//		out.println(session.getAttribute("name"));
//		out.println("<br>");
		
		/* 2. 쿠키
		 * client 시스템으로부터 쿠키 데이터 획득 및 별칭으로 데이터 구분해서 브라우저 출력
		 */
		
		// forward scope - 쿠키 데이터를 client에 저장하기 전 succ로 이동 시 문제 발생
		// 쿠키 사용시에는 redirect로 페이지 이동
		Cookie [] allCookie = request.getCookies();
		for (Cookie c : allCookie) {
			out.println(c.getName() + " - " + c.getValue());
		}
		
		out.println("<button onclick='location.href=\"logout\"'>로그아웃</button>");


	}

}
