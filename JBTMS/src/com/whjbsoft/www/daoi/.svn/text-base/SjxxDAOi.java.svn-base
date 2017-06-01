package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.SjxxDAO;
import com.whjbsoft.www.po.Sjxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class SjxxDAOi extends HibernateDaoSupport implements SjxxDAO {

	public SjxxDAOi() {		
	}

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Sjxx.class, id);
	}

	public Sjxx getSjxx(int id) {		
		return (Sjxx)this.getHibernate_Template().get(Sjxx.class, id);
	}

	public List getSjxxs(String hql, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Sjxx sjxx) throws Exception {
		this.getHibernate_Template().save(sjxx);
	}

	public void update(Sjxx sjxx) throws Exception {
		this.getHibernate_Template().merge(sjxx);
	}

	public void delete(String hql) throws Exception{
		this.getHibernate_Template().delete(hql);
	}
}
