package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Khxx;
import com.whjbsoft.www.util.Pageinfo;

public interface KhxxService {
	int pagerecord = 10;
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//添加客户信息
	public boolean save(int dtzj,int stzj,Khxx khxx);
	//修改客户信息
	public boolean update(int dtzj,int stzj,Khxx khxx);
	//删除客户信息
	public boolean delete(int dtzj,int stzj,String[] ids);
	//查询客户信息
	public Khxx getKhxx(int id);
	//客户搜索
	public Pageinfo getPagedata(int dtzj,int stzj,String con,int curpage,Object...params);
	//客户信息是否存在
	public boolean khExist(String con,Object... params);
	//客户信誉度查询
//	public KhjwtjVo getKhjwtj(int dtzj,int stzj,int ssxs,int sssysz,String khbh,String dwmc);
	
}
