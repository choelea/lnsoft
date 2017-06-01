package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Ylxx;
import com.whjbsoft.www.util.Pageinfo;

public interface ClglService {
	int pagerecord = 10;
	Pageinfo getPageinfo1(String con,int curpage,int djzj,int ktzj,Object...params);
	Pageinfo getPageinfo(String con, int curpage,Object... params);
	Ylxx getYlxx(int id);
	boolean save(Ylxx ylxx,int djzj,int ktzj);
	boolean update(Ylxx ylxx,int djzj,int ktzj);
	boolean delete(String[] pks,int djzj,int ktzj);
	
}
