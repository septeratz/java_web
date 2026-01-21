package step01.test;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DBTest")
public class DBTest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		/* 서버 내부에 별칭으로 등록된 자원을 검색해서 찾아오는 기능의 객체들
		 * java:/comp/env
		 * - component : 재사용 가능한 요소들(객체, 개체)
		 */
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		//실제 자원의 매핑이름으로 해당 자바 객체
		//DataSource : Connection 객체들을 관리하는 매니저
		//설정에 매핑된 개수만큼만 Connection 객체 반환
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		//
		Connection conn = ds.getConnection();
		
		//System.out.println(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
