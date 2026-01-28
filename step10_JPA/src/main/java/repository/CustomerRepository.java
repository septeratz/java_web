package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.entity.Customer;

public class CustomerRepository {
	
	EntityManagerFactory emf = null;
	public CustomerRepository() {
	}
	
	public void insert(Customer customer) {
		emf = Persistence.createEntityManagerFactory("jpaPU");
		// 접속 시도

		// sql 실행해서 검색
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(customer);

		
		tx.commit();
		
		em.close();
		emf.close();
		
	}
	
	public Customer findById(long id) {
		emf = Persistence.createEntityManagerFactory("jpaPU");
		// 접속 시도
		EntityManager em = emf.createEntityManager();

		Customer cust = em.find(Customer.class, id);
		
		em.close();
		emf.close();
		
		return cust;
		
	}
	public void updateName(Long id, String name) {
		emf = Persistence.createEntityManagerFactory("jpaPU");
		// 접속 시도
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer cust = em.find(Customer.class, id);
		cust.setCustName(name);
		
		tx.commit();
		
		em.close();
		emf.close();
		
	}
	public void delete(Long id) {
		emf = Persistence.createEntityManagerFactory("jpaPU");
		// 접속 시도
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Customer cust = em.find(Customer.class, id);
		em.remove(cust);
		
		tx.commit();
		
		em.close();
		emf.close();
		
	}
}
