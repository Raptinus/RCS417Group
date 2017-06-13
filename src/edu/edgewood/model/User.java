package edu.edgewood.model;

import java.util.Date;

//Class representing a user object.
public class User {
	
	private String userId;
	private String firstName;
	private String lastName;
	private String pwd;
	private Date dateRegistered;
	
	
	public User(){}


	public User(String userId, String firstName, String lastName, String pwd, Date dateRegistered) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pwd = pwd;
		this.dateRegistered = dateRegistered;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public Date getDateRegistered() {
		return dateRegistered;
	}


	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	
	
	
	
}
