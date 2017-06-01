package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.HtxxDAO;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class HtxxDAOi extends HibernateDaoSupport implements HtxxDAO{

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Khht.class, id);
	}

	public Dtxx getDtxx(int djzj,int ktzj) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, djzj,ktzj);
	}

	public Khht getHtxx(int id) {
		return (Khht) this.getHibernate_Template().get(Khht.class, id);
	}

	public List getHtxxs(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Khht htxx) throws Exception {
		this.getHibernate_Template().save(htxx);
	}

	public void update(Khht htxx) throws Exception {
		this.getHibernate_Template().update(htxx);
	}
	public Khdd getKhdd(int id) {
		return (Khdd) this.getHibernate_Template().get(Khdd.class, id);
	}
	
}