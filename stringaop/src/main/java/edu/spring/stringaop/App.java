package edu.spring.stringaop;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static ArrayList<ErrorReport> errorReport=new ArrayList<ErrorReport>();
	
    public static void main( String[] args ) 
    {

    	AbstractApplicationContext iocContainer= new ClassPathXmlApplicationContext("AopBean.xml");
   	 	StringOperations obj=(StringOperations) iocContainer.getBean("stringOperationsBean");
    		
   	 	try{
	   	 	try{
	    		System.out.println("Upper Case: "+ obj.getCaptitalString("sfsdf"));
	        }catch(Exception e){}
	   	 	
		   	try{
		   		System.out.println("String Length: "+ obj.getLength("hello"));
		    }catch(Exception e){}
		   	 
		   	try{
	    		System.out.println("Lower Case: "+ obj.getLowerString("sdfdsf"));
	   	 	}catch(Exception e){}
   	 	}
   	 	finally{   	 
   	 		for(ErrorReport err:errorReport){
   	 			System.out.println(err);
   	 		}
   	 	}
    }
    
}
