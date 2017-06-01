package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.util.Pageinfo;

public interface YgxxService {
	int pagerecord = 10;
	public Pageinfo getPagedata(String con,int djzj,int stzj,int curpage,Object... params);
	
	public boolean save (int djzj,int stzj,Ygxx ygxx);
	
	public boolean update(int djzj,int stzj,Ygxx ygxx);

	public Ygxx getYgxx(int pk);
	
	public boolean delYgxx(int djzj,int stzj,String []pk);	
	
	
}
