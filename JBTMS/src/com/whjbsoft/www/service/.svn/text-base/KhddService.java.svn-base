package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.util.Pageinfo;

public interface KhddService {
	int pagerecord = 10;
//	客户订单分页记录
	public Pageinfo getPagedata(int dtzj,int stzj,String con,int curpage,Object...params);
//	客户订单分页记录
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//添加客户订单
	public boolean save(int dtzj,int stzj,Khdd khddb);
	//修改客户订单信息
	public boolean update(int dtzj,int stzj,Khdd khddb);
	//删除客户订单信息
	public boolean delete(int dtzj,int stzj,String[] ids);
	//查询客户订单信息
	public Khdd getKhdd(int id);
	//获取考试要求货品列表
	public List getList(String con,Object... params);
	public boolean valiKhdd(int dtzj, int stzj, int ddzj);
	
}
