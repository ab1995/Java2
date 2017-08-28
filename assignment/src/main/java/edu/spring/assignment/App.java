package edu.spring.assignment;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext iocContainer= new ClassPathXmlApplicationContext("ApplicationBean.xml");
    
        double totalOrderPrice=0;
        String[] orders=iocContainer.getBeanNamesForType(Order.class);
        for(String orderName:orders){
        	Order order=(Order)iocContainer.getBean(orderName);
        	totalOrderPrice+=order.getItemQuantity()*order.getItem().getItemPrice();
        }
        
        System.out.println("Total Order Price: "+totalOrderPrice);
  
    }
}
