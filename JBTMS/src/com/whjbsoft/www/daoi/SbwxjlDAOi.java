package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.SbwxjlDAO;
import com.whjbsoft.www.po.Sbwxjlb;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class SbwxjlDAOi extends HibernateDaoSupport implements SbwxjlDAO{

	public SbwxjlDAOi() {
		
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Sbwxjlb A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Sbwxjlb.class,id);
	}

	public List getObjects(String con, Object... params) {
		StringBuffer hql = new StringBuffer("from Sbwxjlb A where 1=1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Sbwxjlb A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public Sbwxjlb getSbwxjlb(int id) {
		return (Sbwxjlb)this.getHibernate_Template().get(Sbwxjlb.class, id);
	}

	public void save(Sbwxjlb sbwxjl) throws Exception {
		this.getHibernate_Template().save(sbwxjl);		
	}

	public void update(Sbwxjlb sbwxjl) throws Exception {
		this.getHibernate_Template().update(sbwxjl);
	}

}
