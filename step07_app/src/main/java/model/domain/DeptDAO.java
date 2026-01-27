package model.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import model.domain.DeptDTO;
import util.DBUtil;

@Slf4j
public class DeptDAO {
	/* 예외가 발생
	 * 정상 검색 
	 * : 데이터가 있다(ArrayList에 DeptDTO 객체들 저장된 상태로 반환)
	 * : 데이터가 없다(ArrayList에 DeptDTO 객체가 없는 ArrayList 객체만 반환)
	 * 
	 */
	public static ArrayList<DeptDTO> deptAll() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<DeptDTO> allDept = null;
		
		try {
			con = DBUtil.getConnection();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from dept");
			
			allDept = new ArrayList<DeptDTO>();
			
			while (rs.next()) {
				allDept.add(new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), 
										rs.getString("loc")));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e; 
		} finally {
			DBUtil.close(con, stmt, rs);
		}
		
		return allDept;
	}
	
	public static boolean insertDept(DeptDTO dept) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBUtil.getConnection();			
			pstmt = con.prepareStatement("insert into dept values (?, ?, ?)");
			
			//sql문장에만 값 반영
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			//실제 db에 sql문장 실행 
			int result = pstmt.executeUpdate();//1은 정상 저장, 0은 저장 불가, 예외발생  		
			if(result == 1) {
				return true;
			}

		}finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}

	public static boolean updateDept(int deptno, String newLoc) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBUtil.getConnection();			
			pstmt = con.prepareStatement("update dept set loc=? where deptno=?");
			
			//sql문장에만 값 반영
			pstmt.setString(1, newLoc);
			pstmt.setInt(2, deptno);
			
			//실제 db에 sql문장 실행 
			int result = pstmt.executeUpdate();//1은 정상 저장, 0은 저장 불가, 예외발생  		
			if(result == 1) {
				return true;
			} 
		}catch(SQLException e) {
			e.printStackTrace();
			//update 실패 상황의 메세지를 기반으로 새로 생성해서 던짐 - 
			throw new Exception("수정시 실패 재 확인후 재시도 요청 합니다");
		}finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}