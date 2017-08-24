package edu.spring.assignment;

public class Order {

	private Item item;
	private int itemQuantity;
	
	public Order(){
		
	}
	
	public Order(Item item, int itemQuantity) {
		super();
		this.item = item;
		this.itemQuantity = itemQuantity;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	@Override
	public String toString() {
		return "Order [item=" + item + ", itemQuantity=" + itemQuantity + "]";
	}
	
}
