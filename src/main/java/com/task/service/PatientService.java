package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.PatientDao;
import com.task.model.Patients;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;

	public Patients savePatient(Patients patient) {
		return patientDao.save(patient);
	}

	public Patients findPatientByUserUserName(String name) {
		return patientDao.findByUserUserName(name);
	}

}
