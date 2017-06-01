package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Sjxx;
import com.whjbsoft.www.util.Pageinfo;

public interface SjxxService {
	public int pagerecord = 10;
	//获取试卷分页记录
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//添加试卷信息
	public boolean save(Sjxx sjxx,Object...params);
	//修改试卷信息
	public boolean update(Sjxx sjxx,Object...params);
	//删除试卷信息
	public boolean delete(String[] ids,Object...params);
	//查询试卷信息
	public Sjxx getSjxx(int id);
	//试卷编号是否存在
	public boolean nameExist(String con,Object... params);
	//题库试题列表
	public List getStglList(String con,Object... params);
	//考题信息列表
	public List getKtxxList(String con,Object... params);
	//试卷状态修改
	public void updateSjzt(int id,int state);
	//考题类型查询
	public String getKtlx(String ktlx);
	public List getKtxxListFroAction(String con, Object... params);
	public Pageinfo getGoods(String con,int curpage,Object...params);
	public List getSjhp(int id);
	public List getSjhpVo(int sjzj);
	
	public boolean updateKsnr(Sjxx sjxx);
}
