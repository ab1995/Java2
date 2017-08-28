package edu.spring.stringaop;

public class StringOperations {

	public String getCaptitalString(String str){
		if(str!=null)
			return str.toUpperCase();
		else
			throw new NullPointerException("Null Object");
	}
	
	public String getLowerString(String str){
		if(str!=null)
			return str.toLowerCase();
		else
			throw new NullPointerException();		
	}
	
	public int getLength(String str){
		return str.length();
	}
}
