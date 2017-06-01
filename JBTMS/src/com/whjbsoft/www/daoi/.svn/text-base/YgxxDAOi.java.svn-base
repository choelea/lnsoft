package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.YgxxDAO;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class YgxxDAOi extends HibernateDaoSupport implements YgxxDAO {

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Ygxx.class, id);
	}

	public Ygxx getYgxx(int id) {
		return (Ygxx) this.getHibernate_Template().get(Ygxx.class, id);
	}


	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Ygxx ygxx) throws Exception {
		this.getHibernate_Template().save(ygxx);
	}

	public void update(Ygxx ygxx) throws Exception {
		this.getHibernate_Template().update(ygxx);
	}

}
