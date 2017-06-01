package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.ClglDAO;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Ylxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class ClglDAOi extends HibernateDaoSupport implements ClglDAO{

	public int count(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Ylxx.class, id);
	}

	public List getObjects(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public Ylxx getYlxx(int id) {
		return (Ylxx) this.getHibernate_Template().get(Ylxx.class, id);
	}

	public void save(Ylxx ylxx) throws Exception {
		this.getHibernate_Template().save(ylxx);
	}

	public void update(Ylxx ylxx) throws Exception {
		this.getHibernate_Template().update(ylxx);
	}
	
	public Dtxx getDtxx(int djzj, int ktzj) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, djzj,ktzj);
	}

}
