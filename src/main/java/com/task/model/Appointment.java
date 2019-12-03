package com.task.model;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "appointment", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "doctor_id", "start_at", "end_at" }),
		@UniqueConstraint(columnNames = { "patient_id", "start_at", "end_at" }) })
@AssociationOverrides({ @AssociationOverride(name = "id.doctor", joinColumns = @JoinColumn(name = "doctor_id")),
		@AssociationOverride(name = "id.patient", joinColumns = @JoinColumn(name = "patient_id")) })
public class Appointment implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AppointmentCId id;
	@Column(name = "start_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startAppointment;

	@Column(name = "end_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endAppointment;

	private String patiantComplaint;

	public Appointment() {
	}

	public AppointmentCId getId() {
		return id;
	}

	public void setId(AppointmentCId id) {
		this.id = id;
	}

	@Transient
	public Doctors getDoctor() {
		return getId().getDoctor();
	}

	public void setDoctor(Doctors doctor) {
		getId().setDoctor(doctor);
	}

	@Transient
	public Patients getPatients() {
		return getId().getPatient();
	}

	public void setPatient(Patients patient) {
		getId().setPatient(patient);
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

	public String getPatiantComplaint() {
		return patiantComplaint;
	}

	public void setPatiantComplaint(String patiantComplaint) {
		this.patiantComplaint = patiantComplaint;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Appointment that = (Appointment) o;
		if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return (getId() != null ? getId().hashCode() : 0);
	}

}
