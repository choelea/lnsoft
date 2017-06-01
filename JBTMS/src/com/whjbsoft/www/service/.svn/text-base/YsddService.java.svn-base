package com.whjbsoft.www.service;

import java.util.List;
import java.util.Map;

import com.whjbsoft.www.po.Ysddxx;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.util.Pageinfo;

public interface YsddService {
	int pagerecord = 10;
	Pageinfo getPageinfo(String con,int curpage,Object...params);
	Ysddxx getYsddxx(int id);
	boolean save(Ysddxx ysddxx,int djzj,int ktzj,List<Yspsd> list,int bxzj);
	boolean delete(String[] pks,int djzj,int ktzj);
	
	public List getList(int ysddzj);
	public Map<String, Object> getMap(int ysddzj);
	public boolean fc(int ysddzj,int djzj,int ktzj);
	public boolean ysdZc(int ysddzj,int djzj,int ktzj);
}
