package edu.spring.times;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext iocContainer= new ClassPathXmlApplicationContext("AopBean.xml");
    	CreateCollections obj=(CreateCollections)iocContainer.getBean("createCollectionsBean");
    	obj.addInList();
    	obj.addInVector();
    }
}
