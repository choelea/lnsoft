package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Khts;
import com.whjbsoft.www.util.Pageinfo;

public interface KhtsService {
	int pagerecord = 10;
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	public boolean save(Khts khts);
	public boolean update(Khts khts);
	public boolean delete(String[] ids);
	public Khts getKhts(int id);
	
}
