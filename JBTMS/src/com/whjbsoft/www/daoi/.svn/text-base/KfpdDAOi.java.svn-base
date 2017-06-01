package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.KfpdDAO;
import com.whjbsoft.www.po.Kfcppdb;
import com.whjbsoft.www.po.Pddd;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class KfpdDAOi extends HibernateDaoSupport implements KfpdDAO {

	public KfpdDAOi() {
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Pddd A where 1=1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Pddd.class, id);
	}

	public List getObjects(String hql, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Pddd A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public Pddd getPddd(int id) {		
		return (Pddd)this.getHibernate_Template().get(Pddd.class, id);
	}

	public void save(Pddd pddd) throws Exception {
		this.getHibernate_Template().save(pddd);	
	}

	public void update(Pddd pddd) throws Exception {
		this.getHibernate_Template().merge(pddd);
	}

	public void save(Kfcppdb pdb) throws Exception {
		this.getHibernate_Template().save(pdb);
	}
}
