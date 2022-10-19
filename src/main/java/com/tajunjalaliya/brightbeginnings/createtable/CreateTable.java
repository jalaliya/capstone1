package com.tajunjalaliya.brightbeginnings.createtable;



import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.tajunjalaliya.brightbeginnings.entity.Role;
import com.tajunjalaliya.brightbeginnings.entity.User;

public class CreateTable {
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();    
	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();    
	    SessionFactory factory=meta.getSessionFactoryBuilder().build(); 
	    Session session = null;
	    Transaction transaction = null;
	  
	   
	   try 
	   {
		  session=factory.openSession(); 
	    
	    Transaction t=session.beginTransaction();
	    
	    Role r1=new Role("ROLE_FACULTY");
	    Role r2=new Role("ROLE_ADMIN");
	
	  
	 
	   
	    session.save(r1);
	    session.save(r2);
	   
	    
	   ArrayList<Role> list1=new ArrayList<Role>();
	    list1.add(r1);
	    list1.add(r2);
	   
	    
	    User u1=new User("Sayema","Saleem","sayema@gmail.com","$2a$10$ez1qctNJ/cY5dXj0iWn.puS18Yfmh5yDitsSeW1/7h0c0KBA0En96",list1);
	 
	
	  
	    session.save(u1);
	   
	    t.commit();
	   }
	   catch(Exception e)
	   {
		  e.printStackTrace();
	   }
	  
	    finally
	    {
	   
	   factory.close();
	   session.close();
	   System.out.println("Successfully Registered");
	    }
	    
	 
	    
	          
	}

}


