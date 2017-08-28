package edu.spring.times;

import java.util.*;

public class CreateCollections {

	public void addInVector(){
		Vector<Integer> integerVector=new Vector<Integer>();
		for(int i=0;i<1000;i++){
			integerVector.addElement(i);
		}
	}
	
	public void addInList(){
		ArrayList<Integer> integerList=new ArrayList<Integer>();
		for(int i=0;i<1000;i++){
			integerList.add(i);
		}
	}
}
