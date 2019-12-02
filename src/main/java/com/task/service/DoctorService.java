package com.task.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.DoctorDao;
import com.task.dto.DoctorDto;
import com.task.model.Doctors;
import com.task.model.Patients;

@Service
public class DoctorService extends BaseServiceImpl<Doctors> {

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private ModelMapper modelMapper;

	public List<DoctorDto> findAllAppointments() {
		List<Doctors> doctors = doctorDao.findAll();
		List<DoctorDto> doctorsWithAppointments = new ArrayList<DoctorDto>();
		for (Doctors doctor : doctors) {
			doctorsWithAppointments.add(modelMapper.map(doctor, DoctorDto.class));
		}
		return doctorsWithAppointments;
	}

	public Doctors saveDoctors(Doctors doctor) {
		return doctorDao.save(doctor);
	}
	
	public Doctors findByUserUserName(String name) {
		return doctorDao.findByUserUserName(name);
	}
}
