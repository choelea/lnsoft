package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.ZdglDAO;
import com.whjbsoft.www.po.Zdgl;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class ZdglDAOi extends HibernateDaoSupport implements ZdglDAO{

	public ZdglDAOi() {
		
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Zdgl A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Zdgl.class, id);
	}

	public List getObjects(String con, Object... params) {		
		return this.getHibernate_Template().getObjects(con, params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Zdgl A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public Zdgl getZdgl(int id) {		
		return (Zdgl)this.getHibernate_Template().get(Zdgl.class, id);
	}

	public void save(Zdgl zdgl) throws Exception {
		this.getHibernate_Template().save(zdgl);
	}

	public void update(Zdgl zdgl) throws Exception {
		this.getHibernate_Template().merge(zdgl);
	}

}
