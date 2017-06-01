package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Hzgxxx;
import com.whjbsoft.www.util.Pageinfo;

public interface HzgxxxService {
	public int pagerecord = 10;
	//	获取合作关系分页记录
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//添加合作关系信息
	public boolean save(int dtzj,int stzj,Hzgxxx hzgxxx);
	//修改合作关系信息
	public boolean update(int dtzj,int stzj,Hzgxxx hzgxxx);
	//删除合作关系信息
	public boolean delete(int dtzj,int stzj,String[] ids);
	//查询合作关系信息
	public Hzgxxx getHzgxxx(int id);
	//合作关系搜索
	public Pageinfo getPagedata(int dtzj,int stzj,String con,int curpage,Object...params);
	//合作关系信息是否存在
	public boolean hzgxExist(String con,Object... params);
	
}
