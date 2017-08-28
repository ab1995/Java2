package edu.spring.login;

import java.util.ArrayList;
import java.util.HashMap;

public class UserHandler {

	ArrayList<User> userList=new ArrayList<User>();
	ArrayList<String> loggedUser=new ArrayList<String>();
	
	
	public int login(String userName, String password){
		
		if(loggedUser.contains(userName)){
			return 0;
		}
		for(User user:userList){
			if(user.getUsername().equals(userName) && user.getPassword().equals(password)){
				loggedUser.add(user.getUsername());
				return 1;
			}
		}
		return -1;
	}
	
	public boolean logout(String userName){
		if(loggedUser.contains(userName)){
			loggedUser.remove(userName);
			return true;
		}
		else 
			return false;
	}
	
	public boolean register(String firstName, String username, String password, String country){
		if(userList.contains(username)){
			return false;
		}
		else{
			userList.add(new User(firstName, username, password, country));
			return true;
		}
	}
}
