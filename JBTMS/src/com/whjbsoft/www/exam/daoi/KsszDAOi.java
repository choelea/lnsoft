package com.whjbsoft.www.exam.daoi;

import java.util.List;

import com.whjbsoft.www.exam.dao.KsszDAO;
import com.whjbsoft.www.exam.po.Kssz;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class KsszDAOi extends HibernateDaoSupport implements KsszDAO {

	public KsszDAOi() {
		
	}

	public int count(String con, Object... params) {
		StringBuffer sb = new StringBuffer("select count(A) from Kssz A where 1 = 1");
		sb.append(con);
		return this.getHibernate_Template().count(sb.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Kssz.class, id);
	}

	public List getObjects(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer sb = new StringBuffer("select A from Kssz A left join fetch A.sjxx B left join fetch A.bjxx C where 1 = 1");
		sb.append(con);
		return this.getHibernate_Template().getObjects(sb.toString(), curpage, pagerecord, params);
	}

	public Kssz getKssz(int id) {		
		return (Kssz)this.getHibernate_Template().get(Kssz.class, id);
	}

	public void save(Kssz kssz) throws Exception {
		this.getHibernate_Template().save(kssz);
	}

	public void update(Kssz kssz) throws Exception {
		this.getHibernate_Template().merge(kssz);
	}

	public int countHql(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public List getPageHql(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

}
