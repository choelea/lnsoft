package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.BxglDAO;
import com.whjbsoft.www.po.Bxxx;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class BxglDAOi extends HibernateDaoSupport implements BxglDAO{

	public void delete(int id) throws Exception{
		this.getHibernate_Template().delete(Bxxx.class, id);
	}
	
	public int count(String con,Object...params){
		return this.getHibernate_Template().count(con, params);
	}

	public Bxxx getBxgl(int id) {
		return (Bxxx) this.getHibernate_Template().get(Bxxx.class, id);
	}

	public List getObjects(String con, Object... params) {
		return this.getHibernate_Template().getObjects(con, params);
	}

	public List getObjects(String con, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(con, curpage, pagerecord, params);
	}

	public void save(Bxxx bxgl) throws Exception{
		this.getHibernate_Template().save(bxgl);
	}

	public void update(Bxxx bxgl) throws Exception{
		this.getHibernate_Template().merge(bxgl);
	}

	public Dtxx getDtxx(int djzj, int ktzj) {
		String hql = " from Dtxx A where A.djxx.djzj = ? and ktzj = ?";
		return (Dtxx) this.getHibernate_Template().get(hql, djzj,ktzj);
	}

}
