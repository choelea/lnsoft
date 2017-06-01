package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.KhtsDAO;
import com.whjbsoft.www.po.Khts;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class KhtsDAOi extends HibernateDaoSupport implements KhtsDAO {

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Khts.class, id);
	}

	public Khts getKhts(int id) {
		return (Khts) this.getHibernate_Template().get(Khts.class, id);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Khts khts) throws Exception {
		this.getHibernate_Template().save(khts);
	}

	public void update(Khts khts) throws Exception {
		this.getHibernate_Template().update(khts);
	}

}
