package edu.spring.autowire;

public class Department {

	private String dname;

	public Department() {
	}
	public Department(String dname) {
		this.dname = dname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [dname=" + dname + "]";
	}
	
}
