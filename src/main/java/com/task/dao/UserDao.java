package com.task.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

	public User findByUserName(String username);
}
