package corejava.filehandling.serialization;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private double balance;
	private String name;
	private Date dob;
	
	public Account(int id, double balance, String name, Date dob) {
		this.id = id;
		this.balance = balance;
		this.name = name;
		this.dob=dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", name=" + name + "]";
	}
	
	
}
