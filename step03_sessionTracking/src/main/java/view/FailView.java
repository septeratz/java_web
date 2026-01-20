package view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fail")
public class FailView extends HttpServlet {

    protected void SuccessView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.println("FailView SuccessView()");
		process(request, response);    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FailView doGet()");
		process(request, response);   
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FailView doPost()");
		process(request, response);   
	}

	// 방식과 무관하게 공통로직 개발하는 사용자 정의 메소드
	protected void process(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("로그인 실패<br>");
		out.println("<a href='view/login.html'>로그인 화면으로 이동</a>");
		System.out.println("실패 ********");
		
	}

}
