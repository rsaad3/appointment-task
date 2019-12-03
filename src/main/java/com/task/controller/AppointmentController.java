package com.task.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.task.dao.DoctorDao;
import com.task.dao.PatientDao;
import com.task.dto.AppointmentDto;
import com.task.dto.DoctorDto;
import com.task.dto.UserDto;
import com.task.exceptions.UserExistException;
import com.task.exceptions.UserNotFoundException;
import com.task.model.Appointment;
import com.task.model.AppointmentCId;
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

	/*
	 * save user based on the role first save user and then if role docctor it will
	 * create doctor record for this user else will create patient
	 */

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody UserDto userDetial) throws Exception {
		String pass = passwordEncoder.encode(userDetial.getPassword());
		User user = new User(userDetial.getUserName(), pass, userDetial.getRole());
		if (useService.findByUsrName(userDetial.getUserName()).size() > 0) {
			throw new UserExistException();
		}
		user = useService.SaveUser(user);
		if (userDetial.getRole().equalsIgnoreCase("doctor")) {
			Doctors doctor = modelMapper.map(userDetial, Doctors.class);
			doctor.setUser(user);
			doctor = doctorService.saveDoctors(doctor);
			System.out.println(doctor);
		} else {
			Patients patient = modelMapper.map(userDetial, Patients.class);
			patient.setUser(user);
			patient = patientService.savePatient(patient);
		}
		return user;
	}

	/*
	 * get all apppointment when the app start 
	 * to show them in time line components
	 * */
	
	@GetMapping("/appointments")
	@CrossOrigin(origins = "*")
	public List<DoctorDto> listAllAppointments() {
		return doctorService.findAllAppointments();
	}

	@PostMapping("/createAppointment")
	public Appointment createAppointment(@RequestBody AppointmentDto appointmentDto) throws ParseException {
		Doctors doctor = doctorService.findDoctorByUserUserName(appointmentDto.getDoctorUserName());
		Patients patient = patientService.findPatientByUserUserName(appointmentDto.getPatientUserName());
		if (doctor == null) {
			throw new UserNotFoundException();
		}
		if (patient == null) {
			Doctors doctorPatient = doctorService.findDoctorByUserUserName(appointmentDto.getPatientUserName());
			Patients patientDoctor = patientService.findPatientByUserUserName(doctorPatient.getUser().getUserName());
			if (patientDoctor == null) {
				patientDoctor = new Patients();
				patientDoctor.setAddress(doctorPatient.getAddress());
				patientDoctor.setAge(doctorPatient.getAge());
				patientDoctor.setEmail(doctorPatient.getAddress());
				patientDoctor.setName(doctorPatient.getName());
				patientDoctor.setUser(doctorPatient.getUser());
				patient = patientService.savePatient(patientDoctor);
			} else
				patient = patientService.savePatient(patientDoctor);
		}

		AppointmentCId appCid = new AppointmentCId();
		appCid.setDoctor(doctor);
		appCid.setPatient(patient);
		Appointment app = new Appointment();
		app.setId(appCid);
		app.setStartAppointment(new SimpleDateFormat("YYYY-MM-DD HH:mm").parse(appointmentDto.getAppointmentStart()));
		app.setEndAppointment(new SimpleDateFormat("YYYY-MM-DD HH:mm").parse(appointmentDto.getAppointmentEnd()));
		app.setDoctor(doctor);
		app.setPatiantComplaint(appointmentDto.getComplaint());
		List<Appointment> apps = new ArrayList<Appointment>();
		apps.add(app);
		patient.setAppointments(apps);
		patient = patientService.savePatient(patient);
		return app;
	}

}
