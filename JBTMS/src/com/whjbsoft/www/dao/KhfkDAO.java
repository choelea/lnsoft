package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Khfk;

public interface KhfkDAO {
	int count(String hql ,Object...params);
	List list(String hql ,Object...params);
	void save(Khfk khfk) throws Exception;
	void update(Khfk khfk) throws Exception;
	void delete(int id) throws Exception;
	Khfk getKhfk(int id);
	Object getObject(Class clazz,int id);
}
