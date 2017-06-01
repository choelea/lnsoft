package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.SjzdDAO;
import com.whjbsoft.www.po.Hpxx;
import com.whjbsoft.www.po.Sjzdmx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class SjzdDAOi extends HibernateDaoSupport implements SjzdDAO {

	public SjzdDAOi() {
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Sjzdmx A where 1=1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Sjzdmx.class, id);
		String hql = "from Sjzdmx A where A.fqzj = ?";
		List list = this.getHibernate_Template().getObjects(hql,id);
		for(int i=0;i<list.size();i++){
			Sjzdmx sjzdmx = (Sjzdmx)list.get(i);
			this.delete(sjzdmx.getSjzdmxzj());
		}
	}

	public Sjzdmx getSjzdmx(int id) {		
		return (Sjzdmx)this.getHibernate_Template().get(Sjzdmx.class, id);
	}

	public List getSjzdmxs(String con, Object... params) {
		StringBuffer hql = new StringBuffer("from Sjzd A where 1=1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), params);
	}

	public List list(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Sjzdmx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public void save(Sjzdmx sjzdmx) throws Exception {
		this.getHibernate_Template().save(sjzdmx);
	}

	public void update(Sjzdmx sjzdmx) throws Exception {
		this.getHibernate_Template().merge(sjzdmx);
	}

	public List getObjects(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public void delete(Class clazz ,int id) throws Exception {
		this.getHibernate_Template().delete(clazz, id);
	}

	public int goodsCount(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Hpxx A where 1=1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public List goodsList(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Hpxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public void save(Hpxx hpxx) throws Exception {
		this.getHibernate_Template().save(hpxx);
	}

	public void update(Hpxx hpxx) throws Exception {
		this.getHibernate_Template().merge(hpxx);
	}

	public Hpxx getHpxx(int id) {
		return (Hpxx)this.getHibernate_Template().get(Hpxx.class, id);
	}

	public int allCount(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public List getPageinfo(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

}
