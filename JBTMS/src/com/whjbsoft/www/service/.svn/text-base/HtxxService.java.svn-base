package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.util.Pageinfo;

public interface HtxxService {
	public int pagerecord = 10;
	//	获取合同信息分页记录
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//添加合同信息
	public boolean save(int dtzj,int stzj,Khht htxx);
	//修改合同信息
	public boolean update(int dtzj,int stzj,Khht htxx);
	//删除合同信息
	public boolean delete(int dtzj,int stzj,String[] ids);
	//查询合同信息
	public Khht getHtxx(int id);
	//合同信息搜索
	public Pageinfo getPagedata(int dtzj,int stzj,String con,int curpage,Object...params);
	//合同信息是否存在
//	public boolean htxxExist(String con,Object... params);
	
}
