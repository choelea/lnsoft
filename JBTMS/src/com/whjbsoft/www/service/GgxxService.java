package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Ggxx;
import com.whjbsoft.www.util.Pageinfo;

public interface GgxxService {
	public int pagerecord = 10;
	//获取公告分页记录
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//添加公告信息
	public boolean save(Ggxx ggxx);
	//修改公告信息
	public boolean update(Ggxx ggxx);
	//删除公告信息
	public boolean delete(String[] ids);
	//查询公告信息
	public Ggxx getGgxx(int id);
	//班级分页信息
	public Pageinfo getClaPagedata(String con,int curpage,Object...params);
	//查询公告信息列表（分页记录：不fetch班级信息）
	public Pageinfo getGgxxPagedata(String con,int curpage,Object...params);
	
}
