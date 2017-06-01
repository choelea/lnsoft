package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Bxxx;
import com.whjbsoft.www.util.Pageinfo;

public interface BxglService {
	int pagerecord = 10;
	Pageinfo getPageinfo1(String con,int curpage,int djzj,int ktzj,Object...params);
	Pageinfo getPageinfo(String con, int curpage,Object... params);
	Bxxx getBxgl(int id);
	boolean save(Bxxx bxgl,String[] tcdq,String[] tccx,int djzj,int ktzj);
	boolean update(Bxxx bxgl, String[] tcdq,String[] tccx,int djzj,int ktzj);
	boolean delete(String[] pks,int djzj,int ktzj);
	
	
}
