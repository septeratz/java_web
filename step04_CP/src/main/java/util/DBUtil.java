/* 순순 db연동 클래스 구조 - Data Access Object(DAO)가
 * 공통적으로 사용하는 클래스
 * 권장사항 :  
 * 	table당 DAO클래스는 가급적 1:1 권장
 * 	join 작업이 빈번한 구조의 경우 추가 DAO 개발도 있음 
 * 
 * 
 *  ELK & file beat
 *  	- 로그 데이터 자동 read -> filtering -> 적재 -> 시각화
 *  	- 로그 데이터 파이프라인 처리 
 *  	- ai에게 임시 로그 데이터 구성 요청 후 활용
 *  	- 발표(github readme 필수 작업, 팀원들 함께, 커밋 메세지 조율)
 *  	- 스스로 자생력 부각...!!!!!
 */
//trace < debug < info < warn < error < fatal

/* DB설정 정보 별도의 파일로 분리
 * 1단계 : *.properties 파일 생성(src 내부에 저장)
 * 2단계 : 소스 상에서 해당 파일을 자원으로 등록(file 입력 자원화)
 * 3단계 : properties key로 데이터 read해서 사용
 * 참고 : 영어와 숫자의 데이터 파일은 1byte 단위로 read
 * 		 key와 value구조는 key로 데이터 read
 *   
 */



package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

/* web server 내부에 설정된 자원을 사용 
 * - JNDI 기법으로 별칭으로 자원 활용
 * - webserver 내부에 설정 & server가 start 필수 
 */
@Slf4j
public class DBUtil {
	
	private static DataSource ds;
	
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			//ds = (DataSource)envContext.lookup("jdbc/myoracle");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return  ds.getConnection();		
	}

	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}