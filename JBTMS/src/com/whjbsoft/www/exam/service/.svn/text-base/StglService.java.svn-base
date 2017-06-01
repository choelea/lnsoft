package com.whjbsoft.www.exam.service;

import java.util.List;

import com.whjbsoft.www.exam.po.Stgls;
import com.whjbsoft.www.exam.po.Tkgls;
import com.whjbsoft.www.util.Pageinfo;

public interface StglService {
	int pagerecord = 10;
	//题库列表
	public List getTkgldata(String con,Object... params);
	//分页信息
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	//获取列表
	public List getObjects(String con,Object... params);
	//添加信息
	public boolean save(Stgls stgl);
	//修改信息
	public boolean update(Stgls stgl);
	//删除信息
	public boolean delete(String[] ids);
	//主键查询
	public Stgls get(int id);
	//是否存在
	public boolean isExist(String hql,Object... params);
	
	//主键查询题库信息
	public Tkgls getTkgl(int id);
}
