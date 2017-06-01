package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Sjxx;

public interface SjxxDAO {
	//分页查询试卷记录
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//查询指定对象
	public Sjxx getSjxx(int id);
	//添加试卷
	public void save(Sjxx sjxx) throws Exception ;
	//修改试卷信息
	public void update(Sjxx sjxx) throws Exception ;
	//删除试卷信息
	public void delete(int id) throws Exception ;
	//无分页查看试卷信息
	public List getSjxxs(String hql,Object... params);
	//查询数据库总记录数
	public int count(String hql,Object... params);
	//删除试卷试题信息
	public void delete(String hql) throws Exception;
}
