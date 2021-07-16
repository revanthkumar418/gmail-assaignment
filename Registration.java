package com.te.gmail.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.gmail.bean.Gmail;

public class Registration {

	public static void register() {
		Gmail gmail=new Gmail();
		gmail.setUser_id(100);
		gmail.setUser_name("Revanth");
		gmail.setPassword("revanth@123");
		gmail.setEmail("@gmail.com");
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		
		
		try {
			factory=Persistence.createEntityManagerFactory("gmail_db");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			
			transaction.begin();
			manager.persist(gmail);
			
			System.out.println("data inserted succsesfully");
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if(manager!=null) {
				manager.close();
				
			}if(factory!=null) {
				factory.close();
			}
		}
	}

}
