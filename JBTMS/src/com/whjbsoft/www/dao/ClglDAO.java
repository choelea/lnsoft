package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Ylxx;

public interface ClglDAO {
	int count(String hql,int curpage,int pagerecord,Object...params);
	List getObjects(String hql,int curpage,int pagerecord,Object...params);
	void save(Ylxx ylxx) throws Exception;
	void update(Ylxx ylxx) throws Exception;
	void delete(int id) throws Exception;
	Ylxx getYlxx(int id);
	public Dtxx getDtxx(int djzj, int ktzj);

}
