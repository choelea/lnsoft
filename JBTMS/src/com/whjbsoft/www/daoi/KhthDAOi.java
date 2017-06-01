package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.KhthDAO;
import com.whjbsoft.www.po.Khth;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class KhthDAOi extends HibernateDaoSupport implements KhthDAO{

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Khth.class, id);
	}

	public Object getObject(Class clazz, int id) {
		return this.getHibernate_Template().get(clazz, id);
	}

	public List list(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public Khth getKhth(int id) {
		return (Khth) this.getHibernate_Template().get(Khth.class, id);
	}

	public void save(Khth khth) throws Exception {
		this.getHibernate_Template().save(khth);
	}

	public void update(Khth khth) throws Exception {
		this.getHibernate_Template().update(khth);
	}


}
