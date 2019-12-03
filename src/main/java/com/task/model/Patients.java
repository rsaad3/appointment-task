package com.task.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

/*
 * patient can make may appointment but in different date
 *  and with different doctors
 * */
@Entity(name = "patients")
public class Patients extends BaseUser {

	@Id
	@GeneratedValue
	@Column(name = "patient_id")
	private int id;

	@OneToMany(mappedBy = "id.patient", cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<Appointment>();

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	public Patients() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
