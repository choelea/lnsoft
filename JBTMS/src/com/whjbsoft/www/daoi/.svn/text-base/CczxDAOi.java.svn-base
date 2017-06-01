package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.CczxDAO;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class CczxDAOi extends HibernateDaoSupport implements CczxDAO {

	public List getList(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public Object getObject(Class pocalss,int id) {
		return this.getHibernate_Template().get(pocalss, id);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void update(Object obj) throws Exception {
		this.getHibernate_Template().update(obj);
	}



}
