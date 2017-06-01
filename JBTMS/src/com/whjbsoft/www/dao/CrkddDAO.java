package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.po.Sbxx;
import com.whjbsoft.www.po.Ygxx;

public interface CrkddDAO {
	public List list(String hql,int curpage,int pagerecord,Object...params);
	public Crkdd getCrkdd(int id);
	public void save(Crkdd crkdd) throws Exception ;
	public void update(Crkdd crkdd) throws Exception ;
	public void delete(int id) throws Exception ;
	public int count(String hql,Object... params);
	public Ygxx getYgxx(int id);
	public Sbxx getSbxx(int id);
}
