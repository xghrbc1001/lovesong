package com.xc.lovesong.base.dao;

import java.util.List;

import org.hibernate.Query;

public interface BaseDao<T> {

	public T find(Class<T> clazz, int id);

	public void create(T baseBean);

	public void save(T baseBean);

	public void delete(T baseBean);
	
	public List<T> list(String hql);

	public int getTotalCount(String hql, Object... params);
	
	public int getTotalCount(T t);

	public List<T> list(String hql, int firstResult, int maxSize,
			Object... params);

	public Query createQuery(String hql);
}
