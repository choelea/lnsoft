package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.Szcw;

public interface CczxService {
	int pagerecord = 10;
	public Pageinfo getPagedata(String con,int curpage,Object... params);
	public boolean zhijian(int djzj,int stzj,Crkdd vo,String[] hpzj,String []hgsl);
	public boolean rkcz(int dzzj,int stzj,int ddzj,List<Szcw> list);
	public boolean ckcz(int dzzj,int stzj,int ddzj,List<Szcw> list);
	
}
