package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.KhxxDAO;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class KhxxDAOi extends HibernateDaoSupport implements KhxxDAO{

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Khxx.class, id);
	}

	public Dtxx getDtxx(int djzj, int ktzj) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, djzj,ktzj);
	}

	public Khxx getKhxx(int id) {
		return (Khxx) this.getHibernate_Template().get(Khxx.class, id);
	}

	public List getKhxxs(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Khxx khxx) throws Exception {
		this.getHibernate_Template().save(khxx);
	}

	public void update(Khxx khxx) throws Exception {
		this.getHibernate_Template().update(khxx);
	}

}
