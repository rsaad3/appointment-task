package com.task.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/*
 * to divide many to many relationship between doctor and patient
 *  with appointment start and end 
 * */
@Embeddable
public class AppointmentCId implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JsonIgnore
	private Doctors doctor;
	@ManyToOne
	@JsonIgnore
	private Patients patient;
	
	@Column(name = "start_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date startAppointment;

	@Column(name = "end_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date endAppointment;

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AppointmentCId that = (AppointmentCId) o;

		if (doctor != null ? !doctor.equals(that.doctor) : that.doctor != null)
			return false;
		if (patient != null ? !patient.equals(that.patient) : that.patient != null)
			return false;

		return true;
	}

	public Date getStartAppointment() {
		return startAppointment;
	}

	public void setStartAppointment(Date startAppointment) {
		this.startAppointment = startAppointment;
	}

	public Date getEndAppointment() {
		return endAppointment;
	}

	public void setEndAppointment(Date endAppointment) {
		this.endAppointment = endAppointment;
	}

	public int hashCode() {
		int result;
		result = (doctor != null ? doctor.hashCode() : 0);
		result = 31 * result + (patient != null ? patient.hashCode() : 0);
		return result;
	}

}
