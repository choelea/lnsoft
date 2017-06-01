package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Ykdd;

public interface YkddDAO {
	//查询记录总数
	public int count(String con , Object... params);
	//查询分页记录
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//条件查询
	public List getObjects(String con,Object... params);
	//主键查询
	public Ykdd getYkdd(int id);
	//添加信息
	public void save(Ykdd ykdd) throws Exception;
	//修改信息
	public void update(Ykdd ykdd) throws Exception;
	//删除信息
	public void delete(int id) throws Exception;
}
