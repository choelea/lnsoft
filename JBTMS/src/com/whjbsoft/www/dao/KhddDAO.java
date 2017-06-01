package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khdd;

public interface KhddDAO {
	public List list(String hql,int curpage,int pagerecord,Object...params);
	public Khdd getKhdd(int id);
	//添加客户订单
	public void save(Khdd khddb) throws Exception ;
	//修改客户订单信息
	public void update(Khdd  khdd) throws Exception ;
	//删除客户订单信息
	public void delete(int id) throws Exception ;
	//查询数据库总记录数
	public int count(String hql,Object... params);
	//条件查询
	public List getObjects(String hql,Object... params);
	//删除对象
	public void delete(Object obj) throws Exception;
//	获取答题信息
	public Dtxx getDtxx(int djzj,int ktzj);
}
