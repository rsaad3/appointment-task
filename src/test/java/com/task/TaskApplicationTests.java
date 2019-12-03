package com.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	@Test
	void contextLoads() throws ParseException {

	}

}
