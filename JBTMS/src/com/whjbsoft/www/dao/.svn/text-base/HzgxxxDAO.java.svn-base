package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Hzgxxx;

public interface HzgxxxDAO {
//	查询记录
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//查询指定对象
	public Hzgxxx getHzgxxx(int id);
	//添加合作关系
	public void save(Hzgxxx hzgxxx) throws Exception ;
	//修改合作关系信息
	public void update(Hzgxxx hzgxxx) throws Exception ;
	//删除合作关系信息
	public void delete(int id) throws Exception ;
	//验证合作关系是否存在
	public List getHzgxxxs(String hql,Object... params);
	//查询数据库总记录数
	public int count(String hql,Object... params);
	//获取答题信息
	public Dtxx getDtxx(int djzj,int stzj);
}
