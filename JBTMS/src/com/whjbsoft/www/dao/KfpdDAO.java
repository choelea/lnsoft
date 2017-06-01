package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Kfcppdb;
import com.whjbsoft.www.po.Pddd;

public interface KfpdDAO {
	//查询记录总数
	public int count(String con , Object... params);
	//查询分页记录
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//条件查询
	public List getObjects(String con,Object... params);
	//主键查询
	public Pddd getPddd(int id);
	//添加信息
	public void save(Pddd pddd) throws Exception;
	//修改信息
	public void update(Pddd pddd) throws Exception;
	//删除信息
	public void delete(int id) throws Exception;
	//添加盘点信息
	public void save(Kfcppdb pdb) throws Exception;
}
