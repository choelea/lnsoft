package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khht;

public interface HtxxDAO {
	//	查询记录
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//查询指定对象
	public Khht getHtxx(int id);
	//添加合同信息
	public void save(Khht htxx) throws Exception ;
	//修改合同信息
	public void update(Khht htxx) throws Exception ;
	//删除客户信息
	public void delete(int id) throws Exception ;
	//验证合同信息是否存在
	public List getHtxxs(String hql,Object... params);
	//查询数据库总记录数
	public int count(String hql,Object... params);
	//获取答题信息
	Dtxx getDtxx(int djzj,int ktzj);
	public Khdd getKhdd(int id);
}