package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Hpxx;
import com.whjbsoft.www.po.Sjzdmx;
import com.whjbsoft.www.util.Pageinfo;

public interface SjzdService {
	public int pagerecord = 10;
	//获取数据字典明细分页记录
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//添加数据字典明细信息
	public boolean save(Sjzdmx sjzdmx);
	//修改数据字典明细信息
	public boolean update(Sjzdmx sjzdmx);
	//删除数据字典明细信息
	public boolean delete(String[] ids);
	//查询数据字典明细信息
	public Sjzdmx getSjzdmx(int id);
	//数据字典信息
	public List getSjzdList(String con,Object...params);
	//验证数据字典编号和名称是否存在
	public boolean nameExist(String hql,Object... params);
	
	//货品信息分页记录
	public Pageinfo getHpxxPage(String con,int curpage,Object...params);
	//添加货品
	public boolean save(Hpxx hpxx);
	//修改货品
	public boolean update(Hpxx hpxx);
	//删除货品
	public boolean delHp(String[] ids);
	//主键查询货品信息
	public Hpxx getHpxx(int id);
	
	//通用分页
	public Pageinfo getPageinfo(String countHql,String hql,int curpage,int pagesize,Object... params);
}
