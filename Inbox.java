package com.te.gmail.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.te.gmail.bean.Massage;

public class Inbox {

	public static void allmails() {
		
Massage massage=new Massage();
EntityManagerFactory factory=null;
EntityManager manager=null;
try {
	factory=Persistence.createEntityManagerFactory("gmail_db");
	manager=factory.createEntityManager();
	
	manager.getReference(Massage.class, 100);
}
catch( Exception e){
	e.printStackTrace();
}
finally {
	if(factory!=null) {
		factory.close();
	}
	if(manager!=null) {
		manager.close();
	}
}
	}

}
