package edu.spring.chatapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	 AbstractApplicationContext iocContainer= new ClassPathXmlApplicationContext("ApplicationBean.xml");
    	 
         String[] chatrooms=iocContainer.getBeanNamesForType(Chatroom.class);
         for(String chatroomName:chatrooms){
         	Chatroom chatroomContent=(Chatroom)iocContainer.getBean(chatroomName);
         	
         	
         	System.out.println("\n\nUsers: "+ chatroomContent.getChatroomUsers());
         	System.out.println("Messages: "+chatroomContent.getChatroomMessages());
         }      	 
    }
}
