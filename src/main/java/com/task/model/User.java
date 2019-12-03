package com.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * each doctor and patient has one to one relation with user 
 * */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "userName" }) })
public class User {

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int id;
	@Column(unique = true)
	private String userName;
	private String password;
	private String role;

	public User() {
	}

	public User(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
