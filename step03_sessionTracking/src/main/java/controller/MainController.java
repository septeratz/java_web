/* login.html	-> MainController
 * 			 	-> SuccessView
 * 				-> Logout
 * 				-> GoodbyeView
 * 
 */

package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@WebServlet("/one")
@Slf4j
public class MainController extends HttpServlet {
	/* id/pw: fisa/ce만 유효. 이름은 짝꿍이름
	 * 유효한 경우 이름을 요청 객체에 저장 후 forward로 SuccessView로 이동
	 * 무효한 경우 단순 redirect로 FailView로 이동
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainController doGet()");
		process(request, response);   
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		process(request, response);
	}
	// 방식과 무관하게 공통로직 개발하는 사용자 정의 메소드
	protected void process(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String accessTime = now.format(formatter);
		
		log.info(request.getParameter("id") + "님이" + accessTime +"에 접속하였습니다");
		log.info("비밀번호:" + request.getParameter("psw"));
		String ip = request.getRemoteAddr();
		log.info("Client IP: " + ip);
		
		String id = request.getParameter("id");
		String psw = request.getParameter("psw");
		
		if (id.equals("fisa") && psw.equals("ce")) {
			// step01 - session: 서버 메모리에 client가 지속적인 상태 유지를 위한 데이터 저장
			/* 벤더사별 서버 종류와 무관하게 표준 Servlet API로 개발
			 * HttpSession 생성, 데이터 저장, 다음 이동 웹페이지(servlet) 이동
			 * 
			 */
//			HttpSession session = request.getSession(); // 생성
//			System.out.println("생성된 id: " + session.getId());
//			
//			session.setAttribute("id", id);
//			session.setAttribute("name", "김소연");
//			
			
			//step02 - cookie: client 상태 저장값을 client 시스템(브라우저)에 저장
			Cookie cId = new Cookie("id", id);
			Cookie cName = new Cookie("name", "김소연");
			
			// client 시스템 내에 저장하고자 하는 시간 설정 - 초단위
			cId.setMaxAge(60*60*24);
			cName.setMaxAge(60*60*24*365);
			
			// client에 응답			
			response.addCookie(cId);
			response.addCookie(cName);

			request.setAttribute("name", "김소연");
			// forward는 method 요청 방식 유지되면서 웹페이지 이동
//			request.getRequestDispatcher("succ").forward(request, response); 쿠키 사용시 사용 불가
			response.sendRedirect("succ");
			
			System.out.println("succ ****");
		} else {
			response.sendRedirect("fail"); // 응답 해버리고 끝
			System.out.println("******** 의미 없는 코딩 영역");
			// 응답 마무리 후 client의 브라우저가 fail 정보로
			// http://ip:port/context명/fail로 직접 요청(get방식)
		}

		
	}


}
