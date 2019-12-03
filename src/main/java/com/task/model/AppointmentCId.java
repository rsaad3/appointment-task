package com.task.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class AppointmentCId implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JsonIgnore
	private Doctors doctor;
	@ManyToOne
	@JsonIgnore
	private Patients patient;

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

	public int hashCode() {
		int result;
		result = (doctor != null ? doctor.hashCode() : 0);
		result = 31 * result + (patient != null ? patient.hashCode() : 0);
		return result;
	}

}
