package step03.onetoonejoin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import util.DBUtil;

public class Step03RunTest {

	@Test
	public void step01Test() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Team3 t1 = new Team3("축구1팀");//객체생성 : PC
			em.persist(t1); //PC에만 저장된 Entity
			
			Team3 t2 = new Team3("배구1팀");
			em.persist(t2);
			
			em.persist(new Member3("손흥민", t1));   //PC에서 검증 및 활용
			em.persist(new Member3("김연경", t1));  
			em.persist(new Member3("박지성", t2));  
			
			/*Team3 t1 / t2는 Persistence context에 존재 */
//			em.persist(new Member3("박지성2", new Team3())); //PC에 저장 자체를 안 했기 때문에 사용 불가 에러
			
			
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
