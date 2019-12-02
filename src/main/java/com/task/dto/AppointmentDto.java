package com.task.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDto {
	private String patientUserName;
	private String doctorUserName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date appointmentStart;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date appointmentEnd;

	public String getPatientUserName() {
		return patientUserName;
	}

	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}

	public String getDoctorUserName() {
		return doctorUserName;
	}

	public void setDoctorUserName(String doctorUserName) {
		this.doctorUserName = doctorUserName;
	}

	public Date getAppointmentStart() {
		return appointmentStart;
	}

	public void setAppointmentStart(Date appointmentStart) {
		this.appointmentStart = appointmentStart;
	}

	public Date getAppointmEnd() {
		return appointmentEnd;
	}

	public void setAppointmEnd(Date appointmEnd) {
		this.appointmentEnd = appointmEnd;
	}
}
