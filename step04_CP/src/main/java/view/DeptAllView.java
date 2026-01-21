package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.domain.DeptDTO;

//http://ip:port/context/all/succall
@WebServlet("/all/succall")
public class DeptAllView extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		
    		ArrayList<DeptDTO> datas = (ArrayList<DeptDTO>)request.getAttribute("depts");
    		
    		out.println("<table border='1'>");
    		out.println("<tr><th>부서번호</th><th>부서명</th><th>지역</th></tr>");
    		//? 반복문 통해서 table 형식으로 출력
    		for(DeptDTO dept : datas) {
    			out.println("<tr>");
    			
    			out.println("<td>"+dept.getDeptno()+"</td>");
    			out.println("<td>"+dept.getDname()+"</td>");
    			out.println("<td>"+dept.getLoc()+"</td>");
    			
    			out.println("</tr>");
    		}
    		out.println("</table>");
    }

}
/*
 <table border="1">
		<tr><th>부서번호</th><th>부서명</th><th>지역</th></tr>
		반복문?
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		
	</table>
 */
