package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.PatientDao;
import com.task.model.Patients;	

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;
	
	public Patients createPatient(Patients doctor) {
		return patientDao.save(doctor); 
	}
}
