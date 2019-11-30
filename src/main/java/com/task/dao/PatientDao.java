package com.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Patients;

public interface PatientDao extends JpaRepository<Patients, Integer>  {

}
