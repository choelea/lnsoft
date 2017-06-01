package com.whjbsoft.www.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Zdgl;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.ZdtjVo;

public interface ZdglService {
	int pagerecord = 10;
	//分页记录
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	public Pageinfo getPageinfo(int djzj,int stzj,String con,int curpage,Object... params);
	//条件查询
	public List getObjects(String con,Object... params);
	//添加
	public boolean save(int djzj,int stzj,Zdgl zdgl,Khht khht);
	//修改
	public boolean update(int djzj,int stzj,Zdgl zdgl);
	//删除
	public boolean delete(int djzj,int stzj,String[] ids);
	//主键查询
	public Zdgl getZdgl(int id);
	
	//账单核销
	public boolean valiZdgl(int djzj,int stzj,Zdgl zdgl);
	//统计合同费用
	public ZdtjVo countZdfy(int htzj);
	//导出账单
	public boolean exportExcel(int zdzj,HttpServletResponse response);
}
