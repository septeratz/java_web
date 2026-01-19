package one;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/one")
public class step01Page extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Step01Page doGet()");
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Step01Page doPost()");
		process(request, response);
	}
	// 방식과 무관하게 공통로직 개발하는 사용자 정의 메소드
	protected void process(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 3단계: one -> two로 redirect 방식으로 이동
		System.out.println("two로 이동 전");
		response.sendRedirect("two");
		System.out.println("two로 이동 후");
		
//		// 2단계: one -> two로 forward 방식으로 이동
//		System.out.println("two로 이동 전");
//		request.getRequestDispatcher("two").forward(request, response);
//		System.out.println("two로 이동 후");
		
		// 1단계: two로 이동
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<a href='two'>2. two로 이동</a>");
	}


}
