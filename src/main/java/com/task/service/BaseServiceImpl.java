package com.task.service;

import com.task.dao.BaseDao;

public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T, Integer> dao;

	@Override
	public T create(T entity) {
		return dao.save(entity);
	}

}
