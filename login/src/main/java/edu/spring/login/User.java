package edu.spring.login;

public class User {

	private String firstName;
	private String username;
	private String password;
	private String country;
	public User(String firstName, String username, String password, String country) {
		super();
		this.firstName = firstName;
		this.username = username;
		this.password = password;
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", username=" + username + ", password=" + password + ", country="
				+ country + "]";
	}

}
