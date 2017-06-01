package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.DdVo;

public interface CrkddService {
	int pagerecord = 10;
	public Pageinfo getPagedata(String con,int djzj,int stzj,int curpage,Object... params);
	
	public boolean save (int djzj,int stzj,Crkdd crkdd,String popk,String orderKind);
	
	public boolean update(int djzj,int stzj,Crkdd crkdd);

	public Crkdd getCrkdd(int pk);
	public Crkdd getCrkddNoLazy(int pk);
	
	public boolean delCrkdd(int djzj,int stzj,String []pk);	
	public String  getRkddbh(int htzj);
	public DdVo getCrkddDdInfo(int pk) ;
	
	public boolean Dd(int djzj,int stzj,int crkzj,String zjryzj, String[] ccryzj, String[] sbzj);
	
}
