package com.whjbsoft.www.exam.service;

import java.util.List;

import com.whjbsoft.www.exam.po.Kssz;
import com.whjbsoft.www.util.Pageinfo;

public interface KsszService {
	int pagerecord = 10;
//	分页信息
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	//获取列表
	public List getObjects(String con,Object... params);
	//添加信息
	public boolean save(Kssz kssz);
	//修改信息
	public boolean update(Kssz kssz);
	//删除信息
	public boolean delete(String[] ids);
	//主键查询
	public Kssz get(int id);
	
	//修改试验设置状态
	public boolean szState(int id,int state);
	
	public Pageinfo getPageinfo(String countHql,String hql,int curpage,Object... params);
}
