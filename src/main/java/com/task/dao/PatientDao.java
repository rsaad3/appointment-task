package com.task.dao;

import org.springframework.stereotype.Repository;

import com.task.model.Patients;

@Repository
public interface PatientDao extends BaseDao<Patients, Integer> {

}
