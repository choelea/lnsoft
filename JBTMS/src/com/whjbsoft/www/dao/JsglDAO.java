package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Jsgl;

public interface JsglDAO {
	
	public int count(String hql,Object... params);
	
	public List getObjects(String hql,int curpage,int pagerecord,Object...params);
	
	public Jsgl getJsgl(int id);

	public Jsgl getJsgl(String hql,Object...params);
	
	public List getObjects(String hql,Object... params);
	
	public void save(Jsgl jsgl) throws Exception;
	
	public void update(Jsgl jsgl) throws Exception;
	
	public void delete(int id) throws Exception;
	
}
