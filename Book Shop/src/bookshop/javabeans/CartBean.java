package bookshop.javabeans;

import java.util.*;

public class CartBean {

	private   ArrayList<String> selectedBooks=new ArrayList<>();
	
	public ArrayList<String> getCartItems(){
		return selectedBooks;
	}
	
	public void addBookToCart(String[] books){
		if(books!=null && books.length>0){
			for(String book:books){
				this.selectedBooks.add(book);
			}
		}
	}
}
