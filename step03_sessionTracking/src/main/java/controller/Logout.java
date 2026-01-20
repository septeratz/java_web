package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	// 상태 유지 종료
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1단계: 세션 소멸, login.html로 이동
//		HttpSession session = request.getSession();
//		session.invalidate(); // 세션 기능 무효화, 데이터 사용 불가
//		session = null;
//		
//		System.out.println("세션 소멸 성공, 로그아웃 성공");
		
		// 2단계 - client 시스템에 저장되어 있는 id와 name에 매핑된 데이터 삭제
		
		Cookie cId = new Cookie("id", null);
		Cookie cName = new Cookie("name", null);

		response.addCookie(cId);
		response.addCookie(cName);
		
		response.sendRedirect("view/login.html");
	}

}
