package com.wipro.HibernateProject;

import java.util.List;
import java.util.Scanner;

import com.wipro.hibernate.entity.PAN;
import com.wipro.repo.PANRepo;


public class App 
{
	public static void main( String[] args )
    {
    	
    	
    	int choice=0;
    	do {
    	System.out.println("--Menu---");
    	System.out.println("1.--Create PAN---");
    	System.out.println("2.--Find by PAN id---");
    	System.out.println("3.--Update PAN by id---");
    	System.out.println("4.--Delete by  id---");
    	System.out.println("5.--Find All PANDetails---");
    	System.out.println("6.--Find All PAN HolderNames---");
    	System.out.println("7.--Find All PAN HolderNumbers---");
    	System.out.println("8.--Find All PAN Holder By PANNumber---");
    	System.out.println("9.--Find All PAN Holder By PANName---");
    	System.out.println("10.--Exit---");
    	Scanner sc= new Scanner(System.in);    	
    	  choice= sc.nextInt();
    	  
    	
	    	switch(choice)
	    	{
	    		case 1:
	    			PANRepo.createPAN();
	    		break;
	    		case 2:
	    			System.out.println("Please enter pan id:");
	    			int id= sc.nextInt();
	    			PAN pan=PANRepo.findById(id);
	    			System.out.println(pan);
	    			break;
	    		case 3:
	    			PANRepo.updatePAN();
	    			break;
	    			
	    		case 4:
	    			 
	    			System.out.println("Please enter pan id:");
	    			int id1= sc.nextInt();
	    			PANRepo.deleteById(id1);
	    			System.out.println(id1+" is deleted");
	    			break;
	    			
	    		case 5:
	    			List<PAN> list=PANRepo.findAll();
	    			System.out.println(list);
	    			break;
	    		case 6:
	    			List<String> PANNameList=PANRepo.findAllPANNames();
	    			System.out.println(PANNameList);
	    			break;
	    		case 7:
	    			List<String> PANNumList=PANRepo.findAllPANNumbers();
	    			System.out.println(PANNumList);
	    			break;
	    		case 8:
	    			System.out.println("Please enter pan number");
	    			String number=sc.next();
	    			List<PAN> listPAN= PANRepo.findByPANNumber(number);
	    			System.out.println(listPAN);
	    			break;
	    		case 9:
	    			System.out.println("Please enter pan Holders name");
	    			String name=sc.next();
	    			List<PAN> listPANName= PANRepo.findByPANHolderName(name);
	    			System.out.println(listPANName);
	    			break;
	    		case 10:
	    			return;
	    		
	    		default:
	    			System.out.println("Invalid option please try again");
	    			break;
	    	
	    	 }
    
        	 
    	}while(choice!=10);
    }

}
