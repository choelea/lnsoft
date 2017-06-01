package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.KhddDAO;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class KhddDAOi extends HibernateDaoSupport implements KhddDAO{

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Khdd.class,id);
	}

	public void delete(Object obj) throws Exception {
		this.getHibernate_Template().delete(obj);
	}

	public Dtxx getDtxx(int djzj, int ktzj) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, djzj,ktzj);
	}

	public Khdd getKhdd(int id) {
		return (Khdd) this.getHibernate_Template().get(Khdd.class, id);
	}

	public List getObjects(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Khdd khdd) throws Exception {
		this.getHibernate_Template().save(khdd);
	}

	public void update(Khdd khdd) throws Exception {
		this.getHibernate_Template().update(khdd);
	}

}