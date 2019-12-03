package com.task.dto;

/*
 * appointment between doctor and patient with start
 *  and end date of appointment and the patient complaint
 * */

public class AppointmentDto {
	private String patientUserName;
	private String doctorUserName;
	private String appointmentStart;
	private String appointmentEnd;
	private String complaint;

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

	public String getAppointmentStart() {
		return appointmentStart;
	}

	public void setAppointmentStart(String appointmentStart) {
		this.appointmentStart = appointmentStart;
	}

	public String getAppointmentEnd() {
		return appointmentEnd;
	}

	public void setAppointmentEnd(String appointmentEnd) {
		this.appointmentEnd = appointmentEnd;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

}
