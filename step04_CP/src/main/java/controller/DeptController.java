/* dept.html : 버튼 클릭 -> controller -> dao -> db -> dao
 * -> controller -> view(table 형식으로 출력)
 */

package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.domain.DeptDAO;
import model.domain.DeptDTO;

//http://ip:port/context/fisa/dept

@WebServlet("/fisa/dept")
public class DeptController extends HttpServlet {
	/* 어떤 요청인지 구분 -> 해당 로직에 맞게 biz 로직 실행 -> view 지정해서 출력 위임
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);
		/* DB로 select 후에 데이터를 새롭게 저장해서 DeptAllView에게 출력 위임
		 * 요청객체에 저장 -> forward로 이동
		 * 정상 응답 
		 * : 부서정보가 있다면 DeptAllView.java에서 table형식으로 출력 예정
		 * : 부서정보가 없다면 EmptyData.java 유연하게 메세지 출력 예정
		 */
		
		if(command.equals("all")) {
			try {
				ArrayList<DeptDTO> depts = DeptDAO.deptAll();
				if(depts.size() != 0) {
					request.setAttribute("depts", depts); 
					request.getRequestDispatcher("../deptallview.jsp").forward(request, response);
				}else {
					//EmptyData.java
				}
			} catch (SQLException e) {
				e.printStackTrace();
				//예외 발생시 예외처리 화면으로 이동
			}
		}else if(command.equals("insert")) {
			
		}else {
			//무효한 요청
		}
	}

}