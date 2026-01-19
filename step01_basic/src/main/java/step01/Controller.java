package step01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ce")
public class Controller extends HttpServlet {
	
	/* 호출 시점
	 * 1. 최초 client가 호출시 단 한번 실행
	 * 2. 서버에 새롭게 배포된 새로운 소스 인식시 자동으로 재호출
	 * 3. 결론: 다수의 client가 사용되는 객체는 공유되는 단일 객체
	 */   
    public Controller() {
    		System.out.println("Controller 생성자 ***");
    }

    /* 호출 시점
     * 1. <button> 태그에 location.href로 클릭 시
     * 2. <a href> tag 클릭시
     * 3. form의 method 속성 값이 get이거나 method 속성이 생략된 경우
     * 		- <form method="get"> 또는 <form>
     * 4. http통신의 default 방식
     * 5. 사용 권장 시점: url로 web page 즐겨찾기용, 단순 검색 시 주로 사용
     * 		보안을 고려하지 않은 요청시 주로 사용
     * 6. http://ip:port/context명/ce url로 직접 요청시
     * 	- http://www.naver.com or http://www.google.com 등 모두 다 get 요청으로 간주
     * 7. 호출 시점
     * 	- client가 요청 시마다 무조건 실행
     * 8. 호출은 어디서 누가?
     * 	- client가 url로 요청시 container 내부에서 자동 호출
     * 	즉 우리가 개발한 코드 상에선 doGet()을 호출한 적이 없음
     * 9. tomcat 내부에서 자동 호출, 개발자는 스펙에 맞게 메소드 body 재정의
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller doGet() *********");
		// client가 입력한 id/pw값을 받아서 server console창에 단순 출력
		System.out.println(request.getParameter("id")); // id 별칭에 매핑된 데이터 출력
		System.out.println(request.getParameter("pw")); // pw 별칭에 매핑된 데이터 출력
	}

	/* 1. 호출 시점
	 * 	- form tag의 method 속성값이 post로 명시적 호출시에만 호출
	 * 2. 권장 시점
	 * 	- 서버에 데이터 저장 및 수정시
	 * 	- id/pw처럼 보안을 고려한 데이터 전송시 필수로 반영
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller doPost() *********");
		// client가 입력한 id/pw값을 받아서 server console창에 단순 출력
		System.out.println(request.getParameter("id")); // id 별칭에 매핑된 데이터 출력
		System.out.println(request.getParameter("pw")); // pw 별칭에 매핑된 데이터 출력
	}

}

/* 확인 내용
 * 1. 생성자 호출 횟수
 * 2. doGet() 또는 doPost() 메소드가 언제 호출될지?
 * 3. 실습 단계
 * 	1) servlet 직접 호출
 * 		http://ip:port/step01_basic/ce
 * 		http 통신 가능한 확인
 * 	2) html 버튼 방식으로 servlet 이동
 * 		client에게 직접 응답이 가능한 http 통신 재확인
 * 		html에선 순수 자바 코드 호출 불가능(http 통신 가능한 자원에게 요청)
 *
 * 
*/