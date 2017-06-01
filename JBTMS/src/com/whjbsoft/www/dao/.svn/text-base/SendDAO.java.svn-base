package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Yspsd;

public interface SendDAO {
	//分页查询配送订单信息
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//查询指定对象
	public Yspsd getYspsdxx(int id);
	//查询数据库总记录数
	public int count(String hql,Object... params);
	//修改配送单信息
	public void update(Yspsd yspsdxx) throws Exception;
	public void save(Yspsd yspsdxx) throws Exception;
	public void delete(int id) throws Exception;
	//查询所有所需信息
	public List getInfo(String hql,Object...params);
	//获取答题信息
	public Dtxx getDtxx(Object... params);
	public Khht getKhht(int id);
	public Object getObject(String hql,Object...params);
	public Object getObject(Class clazz, int id);
}