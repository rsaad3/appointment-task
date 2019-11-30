package com.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Doctors;

public interface DoctorDao extends JpaRepository<Doctors, Integer> {

}
