package com.task.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * to divide many to many relationship between doctor and patient
 *  with appointment start and end 
 * */
@Embeddable
public class AppointmentId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "patient_id")
	private int patientId;

	@Column(name = "doctor_id")
	private int doctorId;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AppointmentId() {
	}

	public AppointmentId(int patientId, int doctorId) {
		this.patientId = patientId;
		this.doctorId = doctorId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		AppointmentId that = (AppointmentId) o;
		return Objects.equals(patientId, that.patientId) && Objects.equals(doctorId, that.doctorId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(patientId, doctorId);
	}

}
