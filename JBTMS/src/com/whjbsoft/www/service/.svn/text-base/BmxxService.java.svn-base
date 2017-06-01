package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Bmxx;
import com.whjbsoft.www.util.Pageinfo;

public interface BmxxService {
	int pagerecord = 10;
	//分页信息
	public Pageinfo getPageinfo(String con,int curpage,Object... params);	
	//添加部门
	public boolean save(Bmxx bmxx);
	//修改部门
	public boolean update(Bmxx bmxx);
	//删除部门
	public boolean delete(String[] ids);
	//查询部门
	public Bmxx getBmxx(int id);
	//是否存在
	public boolean isExist(String con,Object... params);
	
	
}
