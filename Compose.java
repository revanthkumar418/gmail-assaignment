package com.te.gmail.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.gmail.bean.Gmail;
import com.te.gmail.bean.Massage;

public class Compose {

	public static void mail() {
		Scanner scanner=new Scanner(System.in);
		Massage massage=new Massage();
		Gmail gmail= new Gmail();
		
		System.out.println("type massage to sent");
		String type =scanner.next();
		massage.setMassage(type);
		System.out.println("enter email");
		String email= scanner.next();
		gmail.setEmail(email);
		System.out.println("enter user id");
		int User_id=scanner.nextInt();
		massage.setUser_id(100);
		System.out.println("enter massage id");
		int massage_id =scanner.nextInt();
		massage.setUser_id(massage_id);
		
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		
		
		try {
			factory=Persistence.createEntityManagerFactory("gmail_db");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			
			transaction.begin();
			manager.persist(massage);
			
			System.out.println("massage sent  succsesfully");
			
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
