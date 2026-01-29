package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.domain.Emp;

public class EmpRepository {
	EntityManagerFactory emf = null;
	
	public void copy() {
		emf = Persistence.createEntityManagerFactory("oraclePU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// emp table의 모든 내용을 employeeee에 투입, 매핑
		em.createNativeQuery(
				"INSERT INTO employeeee (emp_no, ename, job, mgr, hiredate, sal, comm, deptno) "
				+ "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp"
					).executeUpdate();

		tx.commit();
		em.close();
		emf.close();
	}
	
	public void updateName() {
		emf = Persistence.createEntityManagerFactory("oraclePU");
		// 접속 시도
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 7361 사원을 찾아 이름을 "스맨"으로 변경
		Emp emp = em.find(Emp.class, 7369l);
		emp.setEname("스맨");
		
		tx.commit();
		
		em.close();
		emf.close();
		
	}
}
