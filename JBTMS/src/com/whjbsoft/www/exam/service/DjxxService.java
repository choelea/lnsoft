package com.whjbsoft.www.exam.service;

import java.util.List;

import com.whjbsoft.www.exam.po.Djxxs;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.vo.SjxxVo;
import com.whjbsoft.www.util.Pageinfo;

public interface DjxxService {
	int pagerecord = 10;
//	分页信息
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	//获取列表
	public List getObjects(String hql,Object... params);
	//添加信息
	public boolean save(Djxxs djxx);
	//修改信息
	public boolean update(Djxxs djxx);
	//删除信息
	public boolean delete(String[] ids);
	//主键查询
	public Djxxs get(int id);
	//主键查询试卷信息
	public Sjxxs getSjxx(int id);
	
	//试卷详细信息
	public List<SjxxVo> getSjst(int id);
//	答卷详细信息
	public List<SjxxVo> getDjst(int id);
	//试验设置分页信息
	public Pageinfo getSyszPage(String con ,int curpage ,Object... params);
}
