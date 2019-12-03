package com.task.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "doctors")
public class Doctors extends BaseUser {

	@Id
	@GeneratedValue
	@Column(name = "doctor_id")
	private int doctorId;
	private double ticketPrice;
	private int startWork;
	private int endWork;
	private String specialization;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "id.doctor", cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<Appointment>();

	public Doctors() {
	}
	
	

	public int getUserId() {
		return doctorId;
	}

	public void setUserId(int userId) {
		this.doctorId = userId;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
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



	@Override
	public String toString() {
		return "Doctors [ticketPrice=" + ticketPrice + ", startWork=" + startWork + ", endWork=" + endWork + "]";
	}

}
