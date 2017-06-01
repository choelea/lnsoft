package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.CrkddDAO;
import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.po.Sbxx;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class CrkddDAOi extends HibernateDaoSupport implements CrkddDAO {

	public Sbxx getSbxx(int id) {
		return (Sbxx) this.getHibernate_Template().get(Sbxx.class, id);
	}

	public Ygxx getYgxx(int id) {
		return (Ygxx) this.getHibernate_Template().get(Ygxx.class, id);
	}

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Crkdd.class, id);
	}

	public Crkdd getCrkdd(int id) {
		return (Crkdd) this.getHibernate_Template().get(Crkdd.class, id);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Crkdd crkdd) throws Exception {
		this.getHibernate_Template().save(crkdd);
	}

	public void update(Crkdd crkdd) throws Exception {
		this.getHibernate_Template().update(crkdd);
	}

}
