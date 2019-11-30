package com.task.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dao.UserDao;
import com.task.dto.DoctorDto;
import com.task.dto.UserDto;
import com.task.model.Doctors;
import com.task.model.Patients;
import com.task.model.User;
import com.task.service.DoctorService;
import com.task.service.PatientService;
import com.task.service.UserService;

@RestController
@RequestMapping("/appointmentApp/api/")
@CrossOrigin(origins = "*")
public class AppointmentController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserService useService;

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody UserDto userDetial) {
		String pass = passwordEncoder.encode(userDetial.getPassword());
		User user = new User(userDetial.getUserName(), pass, userDetial.getRole());
		user = useService.SaveUser(user);
		if (userDetial.getRole().equalsIgnoreCase("doctor")) {
			Doctors doctor = modelMapper.map(userDetial, Doctors.class);
			doctor.setUser(user);
			doctor = doctorService.createDoctor(doctor);
			System.out.println(doctor);
		} else {
			Patients patient = modelMapper.map(userDetial, Patients.class);
			patient.setUser(user);
			patient = patientService.createPatient(patient);
			System.out.println(patient);
		}
		return user;

	}

	@GetMapping("/appointments")
	@CrossOrigin(origins = "*")
	public List<DoctorDto> listAllAppointments() {
		return doctorService.findAllAppointments();
	}

}
