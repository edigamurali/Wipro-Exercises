package com.wipro.repo;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wipro.hibernate.entity.PAN;
import com.wipro.hibernate.util.HibernateUtil;


public class PANRepo {
	 public static void updatePAN()
	    {
	    	
	    	Scanner sc= new Scanner(System.in); 
	    	System.out.println("Please enter PAN id");
	    	int id= sc.nextInt();
	    	System.out.println("Please enter PAN Holder name");
	    	String name= sc.next();
	    	System.out.println("Please enter PAN number");
	    	String number= sc.next();
	    	
	    	PAN pan= new PAN(id,number,name);
	    	save(pan);
	    }
	    
	 public static void createPAN()
	    {
	    	Scanner sc= new Scanner(System.in); 
	    	System.out.println("Please enter PAN Holder name");
	    	String name= sc.next();
	    	System.out.println("Please enter PAN number");
	    	String number= sc.next();
	    	PAN pan= new PAN(number,name);
	    	save(pan);
	    	
	    	
	    }
	    //insert and update
	 public static void save(PAN pan)
	    {
	    	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	
	    	if(pan.getId()!=0)//update
	    	{
	    		PAN pan1=findById(pan.getId());
	    		pan1.setPanholderName(pan.getPanholderName());
	    		pan1.setPanNumber(pan.getPanNumber());
	    		session.persist(pan1);
	    	}
	    	else {//insert
	    	   	session.persist(pan);
	    	}
	    	transaction.commit();     	
	    	
	    }
	    
	 public static PAN findById(int id)
	    {
	     	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	PAN pan=session.find(PAN.class, id);
	    	return pan;
	    	
	    }
	    
	 public static PAN deleteById(int id)
	    {
	     	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	PAN pan=session.find(PAN.class, id);
	    	session.remove(pan);
	    	transaction.commit();
	    	return pan;
	    	
	    }
	    
	 public static List<PAN> findAll()
	    {
	    	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="from PAN";//select * from movie
	    	Query query=session.createQuery(hqlQuery);
	    	List<PAN> list=query.list();
	    	return list;
	    	
	    	
	    	
	    }
	    
	 public static List<String> findAllPANNames()
	    {
	    	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="SELECT panholderName from PAN";//select name from pan_details
	    	Query query=session.createQuery(hqlQuery);
	    	List<String> list=query.list();
	    	return list;   	
	    	
	    	
	    }
	 public static List<String> findAllPANNumbers()
	    {
	    	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="SELECT panNumber from PAN";//select name from pan_details
	    	Query query=session.createQuery(hqlQuery);
	    	List<String> list=query.list();
	    	return list;   	
	    	
	    	
	    }
	 public static List<PAN> findByPANNumber(String PANNumber)
	    {
	    	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="from PAN where panNumber=:panno";//select *  from movie where movie_language=''
	    	Query query=session.createQuery(hqlQuery,PAN.class);
	    	query.setParameter("panno",PANNumber);
	    	List<PAN> list=query.list();
	    	return list;   	
	    	
	    	
	    }
	 
	 public static List<PAN> findByPANHolderName(String name)
	    {
	    	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="from PAN where panholderName=:panname";//select *  from movie where movie_language=''
	    	Query query=session.createQuery(hqlQuery,PAN.class);
	    	query.setParameter("panname",name);
	    	List<PAN> list=query.list();
	    	return list;   	
	    	
	    	
	    }




}
