package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.SbxxDAO;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Sbxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class SbxxDAOi extends HibernateDaoSupport implements SbxxDAO{

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Sbxx.class, id);
	}

	public Dtxx getDtxx(int djzj, int stzj) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and A.ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, djzj,stzj);
	}

	public Sbxx getSbxx(int id) {
		return (Sbxx) this.getHibernate_Template().get(Sbxx.class, id);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Sbxx sbxx) throws Exception {
		this.getHibernate_Template().save(sbxx);
	}

	public void update(Sbxx sbxx) throws Exception {
		this.getHibernate_Template().update(sbxx);
	}

}