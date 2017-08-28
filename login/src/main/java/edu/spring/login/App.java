package edu.spring.login;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext iocContainer= new ClassPathXmlApplicationContext("AopBean.xml");
    	UserHandler obj=(UserHandler)iocContainer.getBean("userHandlerBean");
    	
    	Scanner sc=new Scanner(System.in);
    	
    	int choice=0;
    	
    	do{
    		System.out.println("\n 1] Register User\n 2] Login\n 3] Logout\n 4] Exit\n Enter your choice: ");
    		choice=sc.nextInt();
    		String firstName, userName, password, country;
    		switch(choice){
    		case 1: System.out.println("FirstName: ");
    				firstName=sc.nextLine();
    				sc.nextLine();
    				System.out.println("Username: ");
    				userName=sc.nextLine();
    				System.out.println("Password: ");
    				password=sc.nextLine();
    				System.out.println("Country: ");
    				country=sc.nextLine();
    				obj.register(firstName, userName, password, country);
    			break;
    		case 2:	sc.nextLine();
    				System.out.println("Username: ");
					userName=sc.nextLine();
					System.out.println("Password: ");
					password=sc.nextLine();
					obj.login(userName, password);
    			break;
    		case 3:	sc.nextLine();
    				System.out.println("Username: ");
					userName=sc.nextLine();
					obj.logout(userName);
    			break;
    		case 4:
    			break;
    		default: System.out.println("Incorrect Choice");
    		}
    	}while(choice!=4);
    	
    	
    }
}
