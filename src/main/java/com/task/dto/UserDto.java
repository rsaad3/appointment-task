package com.task.dto;
/*
 * user data transfer between back and front end
 * */
public class UserDto {

	private String email;
	private String name;
	private String userName;
	private String password;
	private String role;
	private int age;
	private String address;
	private String specialization;
	private int startWork;
	private int endWork;
	private double ticketPrice;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getStartWork() {
		return startWork;
	}

	public void setStartWork(int startWork) {
		this.startWork = startWork;
	}

	public int getEndWork() {
		return endWork;
	}

	public void setEndWork(int endWork) {
		this.endWork = endWork;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
