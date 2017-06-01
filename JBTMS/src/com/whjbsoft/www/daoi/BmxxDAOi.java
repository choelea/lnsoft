package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.BmxxDAO;
import com.whjbsoft.www.po.Bmxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class BmxxDAOi extends HibernateDaoSupport implements BmxxDAO {

	public BmxxDAOi() {
		
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Bmxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Bmxx.class,id);
	}

	public Bmxx getBmxx(int id) {		
		return (Bmxx)this.getHibernate_Template().get(Bmxx.class, id);
	}

	public List getObjects(String con, Object... params) {
		StringBuffer hql = new StringBuffer("from Bmxx A where 1=1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Bmxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public void save(Bmxx bmxx) throws Exception {
		this.getHibernate_Template().save(bmxx);
	}

	public void update(Bmxx bmxx) throws Exception {
		this.getHibernate_Template().update(bmxx);
	}

}
