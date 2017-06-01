package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Qwxx;
import com.whjbsoft.www.util.Pageinfo;

public interface QwxxService {
	int pagerecord = 10;
	//分页信息
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	public Pageinfo getPageinfo(int djzj,int stzj,String con,int curpage,Object... params);
	//条件查询
	public List getObjects(String con,Object... params);
	//添加库房
	public boolean save(int djzj,int stzj,Qwxx qwxx);
	//修改库房
	public boolean update(int djzj,int stzj,Qwxx qwxx);
	//删除
	public boolean delete(int djzj,int stzj,String[] ids);
	//主键查询
	public Qwxx getQwxx(int id);
	//库房是否已存在
	public boolean isExist(String con,Object... params);
	
	//获取库房信息
	public Kfxx getKfxx(int id);
	//添加储位
	public boolean saveCwxx(int djzj,int stzj,Qwxx qwxx);
	//修改储位
	public boolean update(Cwxx cwxx);
	//设置储位上限和存储商品类型
	public boolean resetCwxx(Cwxx cwxx);
	//储位列表
	public List getCwxxList(String con,Object... params);
	//修改试题状态
	public void setDtxx(int djzj,int stzj);
}
