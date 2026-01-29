package step04.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.junit.Test;

import util.DBUtil;

public class Step04RunTest {

//	@Test
	public void step03Test() {
		EntityManager em = DBUtil.getEntityManager();
		
		Member4 m = em.find(Member4.class, 1L);
	
		System.out.println(m.getName());//Member table만 검색 		
		
		//System.out.println(m.getTeamId().getTeamId());  //member table 설계
		
		em.close();
		em = null;
	}
	
	
	
	//step02 - 이미 존재하는 table과 데이터가 있다는 가정의 실습
//	@Test
	public void step02Test() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			
			//step01 - team 검색
			Team4 team = em.find(Team4.class, 1L);  
			System.out.println(team.getTeamName());	
			
			//step02 - 팀원명 검색
			List<Member4> all = team.getMembers();
			System.out.println(all.get(0).getName());
			System.out.println(all.get(1).getName());
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
				em = null;
			}
		}
	}
	
	
	//step01 - table생성 및 테이터 저장 -> ddl create를 none으로 수정 후 2단계 실습
	/*
	TEAM_ID|TEAM_NAME|
-------+---------+
      1|축구1팀     |
      2|배구1팀     |
      
MEMBER_ID|NAME|TEAM_ID|
---------+----+-------+
        1|손흥민 |      1|
        2|김연경 |      1|
        3|박찬호 |      1|      
	 */
	@Test 
	public void step01Test() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Team4 t1 = new Team4("축구1팀");
			em.persist(t1);
			em.persist(new Team4("배구1팀"));
			
			em.persist(new Member4("손흥민", t1));  
			em.persist(new Member4("김연경", t1));  
			em.persist(new Member4("박찬호", t1));  
			
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
				em = null;
			}
		}
		
	}
}
