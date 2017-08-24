package edu.spring.chatapp;

public class Message {

	private User user;
	private String message;
	
	public Message() {
	}	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Message [user=" + user + ", message=" + message + "]";
	}
	
}
