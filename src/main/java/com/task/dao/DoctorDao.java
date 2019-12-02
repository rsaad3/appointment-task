package com.task.dao;

import org.springframework.stereotype.Repository;

import com.task.model.Doctors;

@Repository
public interface DoctorDao extends BaseDao<Doctors, Integer> {

	

}
