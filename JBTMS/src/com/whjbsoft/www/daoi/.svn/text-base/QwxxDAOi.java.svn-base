package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.QwxxDAO;
import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Qwxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class QwxxDAOi extends HibernateDaoSupport implements QwxxDAO {

	public QwxxDAOi() {
		
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Qwxx A where 1=1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Qwxx.class,id);
	}

	public List getObjects(String con, Object... params) {
		StringBuffer hql = new StringBuffer("from Qwxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Qwxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public Qwxx getQwxx(int id) {
		return (Qwxx)this.getHibernate_Template().get(Qwxx.class, id);
	}

	public void save(Qwxx qwxx) throws Exception {
		this.getHibernate_Template().save(qwxx);
	}

	public void update(Qwxx qwxx) throws Exception {
		this.getHibernate_Template().merge(qwxx);		
	}

	public void save(Cwxx cwxx) throws Exception {
		this.getHibernate_Template().save(cwxx);
	}

	public void update(Cwxx cwxx) throws Exception {
		this.getHibernate_Template().update(cwxx);
	}

	public List getCwlist(String con, Object... params) {
		StringBuffer hql = new StringBuffer("from Cwxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), params);
	}

	public Cwxx getCwxx(int id) {
		return (Cwxx)this.getHibernate_Template().get(Cwxx.class, id);
	}
	
}
