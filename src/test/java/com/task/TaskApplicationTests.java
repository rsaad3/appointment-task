package com.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.task.dao.BaseDao;
import com.task.dao.DoctorDao;
import com.task.dao.PatientDao;
import com.task.dao.UserDao;
import com.task.model.Doctors;
import com.task.model.Patients;
import com.task.model.User;
import com.task.service.DoctorService;
import com.task.service.PatientService;

@SpringBootTest
class TaskApplicationTests {

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	@Test
	void contextLoads() {
//
//		Calendar c1 = Calendar.getInstance();
//
//		// set Month
//		// MONTH starts with 0 i.e. ( 0 - Jan)
//		c1.set(Calendar.MONTH, 11);
//
//		// set Date
//		c1.set(Calendar.DATE, 30);
//
//		// set Year
//		c1.set(Calendar.YEAR, 2019);
//		c1.set(Calendar.HOUR, 12);
//		Date start = c1.getTime();
//		c1.getTime().setHours(1);
//		Date end = c1.getTime();

		// creating a date object with specified time.

//		User patientUser = new User("rabea", passwordEncoder.encode("rabea"), "patient");
//
//		User doctorUser = new User("ahmed", passwordEncoder.encode("rabea"), "doctor");
//		User patientUser = userDao.findById(1).get();
//		User doctorUser = userDao.findById(2).get();

		Doctors doctor;
//		doctor.setTicketPrice(100.0);
//		doctor.setStartWork(12);
//		doctor.setEndWork(22);
//		doctor.setUser(doctorUser);
//		doctor.setAddress("cairo");
//		doctor.setName("Ahmed");
//		doctor.setEmail("ahmed@dxc.com");

//		doctor = doctorDao.findById(4).get();
//
//		Patients patient = new Patients();
//		patient.setPatiantComplaint("my eyes");
//		patient.setUser(patientUser);
//		patient.setAddress("cairo");
//		patient.setName("rabea");
//		patient.setEmail("rabea@dxc.com");
//		patient = patientDao.save(patient);
//		
//		Appointment app = new Appointment();
//		AppointmentCId appCid = new AppointmentCId();
//		appCid.setDoctor(doctor);
//		appCid.setPatient(patient);
//		app.setId(appCid);
//		app.setStartAppointment(start);
//		app.setEndAppointment(end);
//
//		List<Appointment> apps = new ArrayList<Appointment>();
//		apps.add(app);
//		patient.setAppointments(apps);
//		patientDao.save(patient);
		
		
//		System.out.println(doctorDao.findByEmail("Islam@dxc.com"));
		
		Doctors d = doctorDao.findByUserUserName("Islam");
		System.out.println(d);
		
		Patients p = patientService.findByUserUserName("mohamed");
		System.out.println(p);
	}

}
