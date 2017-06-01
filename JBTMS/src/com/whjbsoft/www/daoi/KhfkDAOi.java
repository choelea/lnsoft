package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.KhfkDAO;
import com.whjbsoft.www.po.Khfk;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class KhfkDAOi extends HibernateDaoSupport  implements KhfkDAO {

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception{
		this.getHibernate_Template().delete(Khfk.class, id);
	}

	public Khfk getKhfk(int id) {
		return (Khfk) this.getHibernate_Template().get(Khfk.class, id);
	}

	public List list(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public void save(Khfk khfk) throws Exception {
		this.getHibernate_Template().save(khfk);
	}

	public void update(Khfk khfk) throws Exception {
		this.getHibernate_Template().update(khfk);
	}

	public Object getObject(Class clazz, int id) {
		return this.getHibernate_Template().get(clazz, id);
	}
}
