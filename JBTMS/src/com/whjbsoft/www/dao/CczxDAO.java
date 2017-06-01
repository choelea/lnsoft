package com.whjbsoft.www.dao;

import java.util.List;

public interface CczxDAO  {
	public List list(String hql,int curpage,int pagerecord,Object...params);
	public Object getObject(Class pocalss,int id);
	public void update(Object obj) throws Exception ;
	public int count(String hql,Object... params);
	public List getList(String hql,Object... params);
}
