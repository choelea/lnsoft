package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Sbxx;
import com.whjbsoft.www.util.Pageinfo;

public interface SbxxService {
	int pagerecord = 10;
	Pageinfo getPageinfo(String con,int curpage,Object...params);
	Pageinfo getPageinfo(int djzj,int ktzj,String con,int curpage,Object...params);
	Sbxx getSbxx(int id);
	boolean save(Sbxx sbxx,int kfzj,int djzj,int ktzj);
	boolean update(Sbxx sbxx,int kfzj,int djzj,int ktzj);
	boolean delete(String[] pks,int djzj,int ktzj);
	
}
