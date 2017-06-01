package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.HzgxxxDAO;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Hzgxxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class HzgxxxDAOi extends HibernateDaoSupport implements HzgxxxDAO{

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Hzgxxx.class, id);
	}

	public Dtxx getDtxx(int djzj, int ktzj) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, djzj,ktzj);
	}

	public Hzgxxx getHzgxxx(int id) {
		return (Hzgxxx) this.getHibernate_Template().get(Hzgxxx.class, id);
	}

	public List getHzgxxxs(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Hzgxxx hzgxxx) throws Exception {
		this.getHibernate_Template().save(hzgxxx);
	}

	public void update(Hzgxxx hzgxxx) throws Exception {
		this.getHibernate_Template().update(hzgxxx);
	}

}