package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.GgxxDAO;
import com.whjbsoft.www.po.Ggxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class GgxxDAOi extends HibernateDaoSupport implements GgxxDAO {

	public GgxxDAOi() {		
	}

	public int count(String hql, Object... params) {		
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Ggxx.class, id);
	}

	public Ggxx getGgxx(int id) {		
		return (Ggxx)this.getHibernate_Template().get(Ggxx.class, id);
	}

	public List getGgxxs(String hql, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public void save(Ggxx ggxx) throws Exception {
		this.getHibernate_Template().save(ggxx);
	}

	public void update(Ggxx ggxx) throws Exception {
		this.getHibernate_Template().merge(ggxx);
	}

}
