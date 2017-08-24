package edu.spring.autowire;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext iocContainer= new ClassPathXmlApplicationContext("ApplicationBean.xml");
    	Employee emp=(Employee)iocContainer.getBean("emp1");
    	System.out.println(emp);
    }
}
