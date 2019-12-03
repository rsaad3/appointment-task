package com.task.dto;

import java.util.List;

import com.task.model.Appointment;
import com.task.model.User;
/*
 * doctor data transfer to get doctor with the appointments
 * */
public class DoctorDto {

	private String name;
	private String email;
	private int startWork;
	private int endWork;
	private List<Appointment> appointments;
	private double ticketPrice;
	private String specialization;

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

	private User user;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DoctorDto [name=" + name + ", email=" + email + ", starteWork=" + startWork + ", endWork=" + endWork
				+ ", appointments=" + appointments + "]";
	}

}
