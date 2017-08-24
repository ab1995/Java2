package edu.spring.chatapp;

import java.util.*;

public class Chatroom {

	
	private ArrayList<Message> chatroomMessages=new ArrayList<Message>();
	private HashSet<User> chatroomUsers=new HashSet<User>();
	
	public Chatroom() {
	}
	
	public ArrayList<Message> getChatroomMessages() {
		return chatroomMessages;
	}
	public void setChatroomMessages(ArrayList<Message> chatroomMessages) {
		this.chatroomMessages = chatroomMessages;
	}
	public HashSet<User> getChatroomUsers() {
		return chatroomUsers;
	}
	public void setChatroomUsers(HashSet<User> chatroomUsers) {
		this.chatroomUsers = chatroomUsers;
	}
	@Override
	public String toString() {
		return "Chatroom [chatroomMessages=" + chatroomMessages + ", chatroomUsers=" + chatroomUsers + "]";
	}
	
}
