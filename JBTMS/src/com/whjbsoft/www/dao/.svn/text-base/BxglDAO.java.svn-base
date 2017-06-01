package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Bxxx;
import com.whjbsoft.www.po.Dtxx;

public interface BxglDAO {
	List getObjects(String con,Object...params);
	List getObjects(String con,int curpage,int pagerecord,Object...params);
	int count(String con,Object...params);
	void save(Bxxx bxgl) throws Exception;
	void update(Bxxx bxgl) throws Exception;
	void delete(int id) throws Exception;
	Bxxx getBxgl(int id);
	Dtxx getDtxx(int djzj,int ktzj);
}
