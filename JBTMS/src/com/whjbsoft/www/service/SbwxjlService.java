package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Sbwxjlb;
import com.whjbsoft.www.util.Pageinfo;

public interface SbwxjlService {
	int pagerecord = 10;
	//分页信息
	public Pageinfo getPageinfo(String con,int curpage,Object... params);	
	//添加维修记录
	public boolean save(Sbwxjlb sbwxjl);
	//修改维修记录
	public boolean update(Sbwxjlb sbwxjl);
	//删除维修记录
	public boolean delete(String[] ids);
	//查询维修记录
	public Sbwxjlb getSbwxjlb(int id);
	
}
