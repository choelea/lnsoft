package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.po.Jsgl;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class JsglDAOi extends HibernateDaoSupport implements
		com.whjbsoft.www.dao.JsglDAO {

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Jsgl.class, id);
	}

	public Jsgl getJsgl(int id) {
		return (Jsgl) this.getHibernate_Template().get(Jsgl.class, id);
	}

	public List getObjects(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord, params);
	}

	public List getObjects(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public void save(Jsgl jsgl) throws Exception {
		this.getHibernate_Template().save(jsgl);
	}

	public void update(Jsgl jsgl) throws Exception {
		this.getHibernate_Template().update(jsgl);
	}

	public Jsgl getJsgl(String hql,Object...params) {
		Jsgl jsgl = (Jsgl) this.getHibernate_Template().get(hql,params);
		return jsgl;
	}

}
