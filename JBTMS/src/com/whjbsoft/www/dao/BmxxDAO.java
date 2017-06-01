package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Bmxx;

public interface BmxxDAO {
	//查询总记录数
	public int count(String con , Object... params);
	// 查询分页记录
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//条件查询列表
	public List getObjects(String con , Object... params);
	//添加部门
	public void save(Bmxx bmxx) throws Exception;
	//修改部门
	public void update(Bmxx bmxx) throws Exception;
	//删除部门
	public void delete(int id) throws Exception;
	//查询部门
	public Bmxx getBmxx(int id);
	
}
