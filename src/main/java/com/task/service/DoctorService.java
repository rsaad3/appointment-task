package com.task.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.DoctorDao;
import com.task.dto.DoctorDto;
import com.task.model.Doctors;

@Service
public class DoctorService {

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

	public Doctors findDoctorByUserUserName(String name) {
		return doctorDao.findByUserUserName(name);
	}
}
