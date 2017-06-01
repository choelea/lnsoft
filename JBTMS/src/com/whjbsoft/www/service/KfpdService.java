package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Pddd;
import com.whjbsoft.www.util.Pageinfo;

public interface KfpdService {
	public int pagerecord = 10;
	//分页记录
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	public Pageinfo getPageinfo(int djzj,int stzj,String con,int curpage,Object... params);
	//条件查询
	public List getObjects(String con,Object... params);
	//添加
	public boolean save(int djzj,int stzj,Pddd pddd);
	//修改
	public boolean update(int djzj,int stzj,Pddd pddd);
	//删除
	public boolean delete(int djzj,int stzj,String[] ids);
	//主键查询
	public Pddd getPddd(int id);
	
	//移库执行
	public boolean pdczState(int djzj,int stzj,int id);
}
