package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.entity.Member;

public class JpaMain {
	/* 이미 존재하는 table의 pk값으로 데이터 하나만 검색
	 * 검색된 데이터의 값 일부만 수정
	 * - 검색: find(어떤 entity, pk)
	 * 		- persistence Context에 검색된 내용을 Entity 객체로 생성해서 저장
	 * 		- 한 번 검색된 결과와 동일한 entity를 추가 검색할 경우 select는 한 번만 실행
	 * 		- 단, clear() 메소드로 persistence Context 영역 삭제 후 find할 경우 select문 다시 실행
	 * - 수정: set~~~()
	 * 		- update, 단 commit이 이뤄져야먄 실행됨
	 * - 수정 내용 반영: commit()
	 */
	// step03 - 스펙에 맞게 예제를 직접 구성: persistence Context 확인
	// public static void main(String[] args) {
	public void step03() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		
		/* persistence Context 검색 -> 없음 -> select 문장 생성 및 db 검색
		 * -> 검색 결과는 Member entity로 생성, persistence Context 영역에 저장
		 * 	: snapshot, id 구분하도록 관리
		 * -> find() 반환 
		 * 
		 */
		
		
		Member m = em.find(Member.class, 1l); // 1은 int로 간주, 1L or 1l로 long값 표현
		System.out.println(m); // Member(id=1, name=연아)
		/* persistence Context 검색 -> 있음 ->  -> find() 반환
		 */
		em.clear();

		Member m2 = em.find(Member.class, 1l); // 1은 int로 간주, 1L or 1l로 long값 표현
		System.out.println(m2);
		

		em.close();
		emf.close();
	}
	
	// step02 - find()/remove()
	// public static void step02() {
	public static void main(String[] args) {
		// 접속 시도
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

		// sql 실행해서 검색
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// select * from member where id=1;
		// 검색된 데이터값으로 Member 객체 생성
		Member m = em.find(Member.class, 1l); // 1은 int로 간주, 1L or 1l로 long값 표현
		System.out.println(m); // Member(id=1, name=연아)
		
		// 수정 - tx 적용 필수
		// update member set name='이순신' where id=1;
		// 첫 실행 시 다음 값으로 수정되고, 다음 실행 시 select만 실행되고 update는 실행되지 않음
		m.setName("안유진");
		System.out.println(m);
		
		em.remove(m);
		
		
		// 수정 내용 실 반영, tx처리
		// 자원 반납
		
		tx.commit();
		em.close();
		emf.close();
	}
	// step01 - 단순 test
    public static void step01() {
    		/* persistence.xml파일의 db 설정 정보를 기반으로 생성되는 객체
    		 * - db접속, 관리
    		 * - entity 클래스 관리(table 생성, 유지 등)
    		 * - db접속, sql 문장 실행(drop, create) - DDL
    		 * - EntityManager 객체들을 생성해서 제공하는 핵심 API
    		 */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

        /* EntityManager
         * - CRUD(Insert, Read(select), Update, Delete) 작업용 API
         * - persist(): insert sql 메소드
         * 
         * EntityTransaction 
         * - tx: insert/update/delete 문장만 tx와 연계
         * - EntityManager로부터 생성
         * 	: 어떤 DB, 어떤 table에 대한 정보를 보유한 객체로부터 생성해야만 하기 때문
         * - begin(): tx 시작 의미
         * - commit(): commit 영구 저장하는 sql 명령어
         * - rollback(): 작업 복원 메소드
         */
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member m1 = new Member();
        m1.setName("연아");
        em.persist(m1);
        
        m1.setName("재석");
//        tx.commit();

        em.close();
        emf.close();
    }
}
