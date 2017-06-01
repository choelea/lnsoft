package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Sbwxjlb;

public interface SbwxjlDAO {
//	查询总记录数
	public int count(String con , Object... params);
	// 查询分页记录
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//条件查询列表
	public List getObjects(String con , Object... params);
	//添加维修记录
	public void save(Sbwxjlb sbwxjl) throws Exception;
	//修改维修记录
	public void update(Sbwxjlb sbwxjl) throws Exception;
	//删除维修记录
	public void delete(int id) throws Exception;
	//查询维修记录
	public Sbwxjlb getSbwxjlb(int id);
}
