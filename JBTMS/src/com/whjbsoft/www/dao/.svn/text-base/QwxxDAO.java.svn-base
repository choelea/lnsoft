package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Qwxx;

public interface QwxxDAO {
//	查询记录总数
	public int count(String con , Object... params);
	//查询分页记录
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//条件查询
	public List getObjects(String con,Object... params);
	//主键查询
	public Qwxx getQwxx(int id);
	//添加库房
	public void save(Qwxx qwxx) throws Exception;
	//修改库房
	public void update(Qwxx qwxx) throws Exception;
	//删除库房
	public void delete(int id) throws Exception;
	//添加储位
	public void save(Cwxx cwxx) throws Exception;
	//修改储位
	public void update(Cwxx cwxx) throws Exception;
	//储位列表
	public List getCwlist(String con,Object... params);
	//储位信息
	public Cwxx getCwxx(int id);
}
