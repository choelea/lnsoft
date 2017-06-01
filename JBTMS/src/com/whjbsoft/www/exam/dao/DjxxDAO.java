package com.whjbsoft.www.exam.dao;

import java.util.List;

import com.whjbsoft.www.exam.po.Djxxs;

public interface DjxxDAO {
//	统计数据库记录
	public int count(String con,Object... params);
	//条件查询
	public List getObjects(String hql,Object... params);
	//分页记录信息
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//添加记录
	public void save(Djxxs djxx) throws Exception;
	//修改记录
	public void update(Djxxs djxx) throws Exception;
	//删除记录
	public void delete(int id) throws Exception;
	//主键查询
	public Djxxs getDjxx(int id);
}
