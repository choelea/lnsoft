package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.YsddDAO;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Ysddxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class YsddDAOi extends HibernateDaoSupport implements YsddDAO{

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Ysddxx.class, id);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public Ysddxx getYsddxx(int id) {
		return (Ysddxx) this.getHibernate_Template().get(Ysddxx.class, id);
	}

	public void save(Ysddxx ysddxx) throws Exception {
		this.getHibernate_Template().save(ysddxx);
	}

	public void update(Ysddxx ysddxx) throws Exception {
		this.getHibernate_Template().update(ysddxx);
	}
	
	public Dtxx getDtxx(Object...params) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, params);
	}
	public Object getObject(Class clazz,int id) {
		return this.getHibernate_Template().get(clazz, id);
	}

	public List getObjects(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

}