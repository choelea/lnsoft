package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Ysddxx;

public interface YsddDAO {
	List list(String hql,int curpage,int pagerecord,Object...params);
	int count(String hql,Object...params);
	void save(Ysddxx ysddxx) throws Exception;
	void update(Ysddxx ysddxx) throws Exception;
	void delete(int id) throws Exception;
	Ysddxx getYsddxx(int id);
	public Dtxx getDtxx(Object...params);
	public Object getObject(Class clazz,int id) ;
	public List getObjects(String hql,Object...params);
}
