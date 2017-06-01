package com.whjbsoft.www.exam.service;

import java.util.List;

import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.vo.SjxxVo;
import com.whjbsoft.www.util.Pageinfo;

public interface SjxxService {
	int pagerecord = 10;
//	分页信息
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	//获取列表
	public List getObjects(String hql,Object... params);
	//添加信息
	public boolean save(Sjxxs sjxx);
	//修改信息
	public boolean update(Sjxxs sjxx);
	//删除信息
	public boolean delete(String[] ids);
	//主键查询
	public Sjxxs get(int id);
	//是否存在
	public boolean isExist(String hql,Object... params);
	
	//试卷详细信息
	public List<SjxxVo> getSjst(int id);
	//修改试卷状态
	public boolean sjState(int id,int sjzt);
}
