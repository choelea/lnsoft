package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Ggxx;

public interface GgxxDAO {
	//查询记录
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//查询指定对象
	public Ggxx getGgxx(int id);
	//添加公告
	public void save(Ggxx ggxx) throws Exception ;
	//修改公告信息
	public void update(Ggxx ggxx) throws Exception ;
	//删除公告信息
	public void delete(int id) throws Exception ;
	//验证公告名是否存在
	public List getGgxxs(String hql,Object... params);
	//查询数据库总记录数
	public int count(String hql,Object... params);
}
