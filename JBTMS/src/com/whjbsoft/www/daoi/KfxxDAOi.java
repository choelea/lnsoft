package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.KfxxDAO;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class KfxxDAOi extends HibernateDaoSupport implements KfxxDAO {

	public KfxxDAOi() {
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Kfxx A where 1=1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Kfxx.class,id);
	}

	public Kfxx getKfxx(int id) {
		return (Kfxx)this.getHibernate_Template().get(Kfxx.class, id);
	}

	public List getObjects(String con, Object... params) {
		StringBuffer hql = new StringBuffer("from Kfxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Kfxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public void save(Kfxx kfxx) throws Exception {
		this.getHibernate_Template().save(kfxx);
	}

	public void update(Kfxx kfxx) throws Exception {
		this.getHibernate_Template().merge(kfxx);
	}

}
