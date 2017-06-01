package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Hpxx;
import com.whjbsoft.www.po.Sjzdmx;

public interface SjzdDAO {
	//查询记录
	public List list(String con,int curpage,int pagerecord,Object...params);
	//查询指定对象
	public Sjzdmx getSjzdmx(int id);
	//添加参数
	public void save(Sjzdmx sjzdmx) throws Exception ;
	//修改参数信息
	public void update(Sjzdmx sjzdmx) throws Exception ;
	//删除参数信息
	public void delete(int id) throws Exception ;
	//数据字典信息
	public List getSjzdmxs(String con,Object... params);
	//查询数据库总记录数
	public int count(String con,Object... params);
	//判定数据是否存在（通用）
	public List getObjects(String hql,Object... params);
	//货品分页信息
	public List goodsList(String con,int curpage,int pagerecord,Object...params);
	//货品总记录数
	public int goodsCount(String con,Object... params);
	//添加货品
	public void save(Hpxx hpxx) throws Exception;
	//修改货品
	public void update(Hpxx hpxx) throws Exception;
	//删除货品
	public void delete(Class clazz,int id) throws Exception;
	//查询货品信息
	public Hpxx getHpxx(int id);
	
	//通用分页记录数
	public int allCount(String hql,Object... params);
	//通用分页记录
	public List getPageinfo(String hql,int curpage,int pagerecord,Object...params);
}
