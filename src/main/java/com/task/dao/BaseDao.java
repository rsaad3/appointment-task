package com.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.task.model.Doctors;

@NoRepositoryBean
public interface BaseDao<T,ID> extends JpaRepository<T, ID>{
	public T findByEmail(String email);
	public T findByUserUserName(String name);
}
