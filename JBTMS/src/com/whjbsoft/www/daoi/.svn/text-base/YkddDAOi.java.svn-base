package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.YkddDAO;
import com.whjbsoft.www.po.Ykdd;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class YkddDAOi extends HibernateDaoSupport implements YkddDAO{

	public YkddDAOi() {
		
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Ykdd A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Ykdd.class, id);
	}

	public List getObjects(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select A from Ykmx A inner join fetch A.cwxxByCwzj B inner join fetch A.cwxxByCwxCwzj C inner join fetch B.qwxx D inner join fetch C.qwxx E where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), params);
	}

	public List getPageinfo(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Ykdd A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public Ykdd getYkdd(int id) {
		return (Ykdd)this.getHibernate_Template().get(Ykdd.class, id);
	}

	public void save(Ykdd ykdd) throws Exception {
		this.getHibernate_Template().save(ykdd);
	}

	public void update(Ykdd ykdd) throws Exception {
		this.getHibernate_Template().merge(ykdd);
	}

}
