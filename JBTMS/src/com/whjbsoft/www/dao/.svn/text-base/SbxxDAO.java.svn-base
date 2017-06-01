package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Sbxx;

public interface SbxxDAO {
	List list(String hql,int curpage,int pagerecord,Object...params);
	int count(String hql,Object...params);
	Sbxx getSbxx(int id);
	void save(Sbxx sbxx) throws Exception;
	void update(Sbxx sbxx) throws Exception;
	void delete(int id) throws Exception;
	Dtxx getDtxx(int djzj,int stzj);

}
