package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Kfxx;

public interface KfxxDAO {
	//查询记录总数
	public int count(String con , Object... params);
	//查询分页记录
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//条件查询
	public List getObjects(String con,Object... params);
	//主键查询
	public Kfxx getKfxx(int id);
	//添加库房
	public void save(Kfxx kfxx) throws Exception;
	//修改库房
	public void update(Kfxx kfxx) throws Exception;
	//删除库房
	public void delete(int id) throws Exception;
	
}
