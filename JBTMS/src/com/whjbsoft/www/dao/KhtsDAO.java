package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Khts;

public interface KhtsDAO {
	public List list(String hql,int curpage,int pagerecord,Object...params);
	public Khts getKhts(int id);
	public void save(Khts khts) throws Exception ;
	public void update(Khts khts) throws Exception ;
	public void delete(int id) throws Exception ;
	public int count(String hql,Object... params);
}
