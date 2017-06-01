package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Khth;
import com.whjbsoft.www.util.Pageinfo;

public interface KhthService {
	int pagerecord = 10;
	Pageinfo getPageinfo(String con,int curpage,Object...params);
	boolean save(Khth khth);
	boolean update(Khth khth);
	boolean delete(String[] pks);
	Khth getKhth(int id);
	
}
