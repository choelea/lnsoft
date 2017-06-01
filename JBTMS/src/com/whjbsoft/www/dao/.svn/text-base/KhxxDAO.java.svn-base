package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khxx;

public interface KhxxDAO {
	//	查询记录
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//查询指定对象
	public Khxx getKhxx(int id);
	//添加客户
	public void save(Khxx khxx) throws Exception ;
	//修改客户信息
	public void update(Khxx khxx) throws Exception ;
	//删除客户信息
	public void delete(int id) throws Exception ;
	//验证客户名是否存在
	public List getKhxxs(String hql,Object... params);
	//查询数据库总记录数
	public int count(String hql,Object... params);
	//获取答题信息
	public Dtxx getDtxx(int djzj,int ktzj);
}
