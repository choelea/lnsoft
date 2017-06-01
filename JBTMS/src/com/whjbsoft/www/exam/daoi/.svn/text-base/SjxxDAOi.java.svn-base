package com.whjbsoft.www.exam.daoi;

import java.util.List;

import com.whjbsoft.www.exam.dao.SjxxDAO;
import com.whjbsoft.www.exam.po.Sjkts;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class SjxxDAOi extends HibernateDaoSupport implements SjxxDAO {

	public SjxxDAOi() {
	}

	public int count(String con, Object... params) {
		StringBuffer sb = new StringBuffer("select count(A) from Sjxxs A where 1=1");
		sb.append(con);
		return this.getHibernate_Template().count(sb.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Sjxxs.class,id);
	}

	public List getObjects(String hql, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer sb = new StringBuffer("from Sjxxs A where 1=1");
		sb.append(con);
		return this.getHibernate_Template().getObjects(sb.toString(), curpage, pagerecord, params);
	}

	public Sjxxs getSjxx(int id) {		
		return (Sjxxs)this.getHibernate_Template().get(Sjxxs.class, id);
	}

	public void save(Sjxxs sjxx) throws Exception {
		this.getHibernate_Template().save(sjxx);
	}
	public void save(Sjkts sjkt) throws Exception{
		this.getHibernate_Template().save(sjkt);
	}
	public void update(Sjxxs sjxx) throws Exception {
		this.getHibernate_Template().merge(sjxx);
	}

}
