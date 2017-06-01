package com.whjbsoft.www.exam.daoi;

import java.util.List;

import com.whjbsoft.www.exam.dao.DjxxDAO;
import com.whjbsoft.www.exam.po.Djxxs;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class DjxxDAOi extends HibernateDaoSupport implements DjxxDAO {

	public DjxxDAOi() {
	}

	public int count(String con, Object... params) {
		StringBuffer sb = new StringBuffer("select count(A) from Djxxs A where 1 = 1");
		sb.append(con);
		return this.getHibernate_Template().count(sb.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Djxxs.class, id);
	}

	public Djxxs getDjxx(int id) {	
		return (Djxxs)this.getHibernate_Template().get(Djxxs.class, id);
	}

	public List getObjects(String hql, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer sb = new StringBuffer("select A from Djxxs A left join fetch A.xsxx B left join fetch A.sjxx C where 1 = 1");
		sb.append(con);
		return this.getHibernate_Template().getObjects(sb.toString(), curpage, pagerecord, params);
	}

	public void save(Djxxs djxx) throws Exception {
		this.getHibernate_Template().save(djxx);
	}

	public void update(Djxxs djxx) throws Exception {
		this.getHibernate_Template().merge(djxx);
	}

}
