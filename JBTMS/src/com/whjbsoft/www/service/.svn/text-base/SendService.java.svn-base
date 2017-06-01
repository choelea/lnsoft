package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.util.Pageinfo;

public interface SendService {
	int pagerecord = 10;
	public Pageinfo getPagedata(int djzj,int ktzj,String con,int curpage,Object...params);
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	public boolean save(int djzj,int ktzj,Yspsd yspsd);
	public boolean delete(int djzj,int ktzj,String[] pks);
	public Yspsd getYspsdxx(int id);
	public boolean update(int djzj,int ktzj,Yspsd yspsdxx);
	public boolean task(int djzj, int ktzj, int ysdzj) ;
	public boolean ddqs(int djzj,int ktzj,Yspsd yspsd);
//	public List<HpxxVo> getTraGoods(int traPk);
	
}
