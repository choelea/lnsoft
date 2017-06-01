package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.SendDAO;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class SendDAOi extends HibernateDaoSupport implements SendDAO{

	public void save(Yspsd yspsdxx) throws Exception {
		this.getHibernate_Template().save(yspsdxx);
	}

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public Dtxx getDtxx(Object... params) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, params);
	}

	public List getInfo(String hql, Object... params) {
		return null;
	}

	public Yspsd getYspsdxx(int id) {
		return (Yspsd) this.getHibernate_Template().get(Yspsd.class, id);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void update(Yspsd yspsdxx) throws Exception {
		this.getHibernate_Template().merge(yspsdxx);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Yspsd.class, id);
	}
	public Khht getKhht(int id) {
		return (Khht) this.getHibernate_Template().get(Khht.class, id);
	}

	public Object getObject(String hql, Object... params) {
		return this.getHibernate_Template().get(hql, params);
	}
	public Object getObject(Class clazz, int id) {
		return this.getHibernate_Template().get(clazz, id);
	}

}