package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.util.Pageinfo;

public interface KfxxService {
	int pagerecord = 10;
	//分页记录
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	public Pageinfo getPageinfo(int djzj,int stzj,String con,int curpage,Object... params);
	//条件查询
	public List getObjects(String con,Object... params);
	//添加库房
	public boolean save(int djzj,int stzj,Kfxx kfxx);
	//修改库房
	public boolean update(int djzj,int stzj,Kfxx kfxx);
	//删除
	public boolean delete(int djzj,int stzj,String[] ids);
	//主键查询
	public Kfxx getKfxx(int id);
	//库房是否已存在
	public boolean isExist(String con,Object... params);
	
}
