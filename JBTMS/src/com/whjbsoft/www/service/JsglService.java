package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Jsgl;
import com.whjbsoft.www.util.Pageinfo;

public interface JsglService {
	int pagerecord = 10;
	public Pageinfo getPagedata(String con,int curpage,Object... params);
	
	public boolean save (Jsgl jsgl);
	
	public boolean update(Jsgl jsgl);

	public Jsgl getJsgl(int pk);
	
	public boolean isExistJsgl(int sign,String fieldName,String fieldValue);
	
	public boolean delJsgl(String []pk);	
	boolean isExist(String hql, Object... params);
}
