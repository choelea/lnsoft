package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.util.Pageinfo;

public interface BjglService {
	int pagerecord = 10;
	public Pageinfo getPagedata(String con,int curpage,Object... params);
	
	public boolean save (Bjxx bjgl,int jsid);
	
	public boolean update(Bjxx bjgl);

	public Bjxx getBjgl(int pk);
	
	public boolean isExistBjgl(int sign,String fieldName,String fieldValue);
	
	public boolean delBjgl(String []pk);	
	
	
}
