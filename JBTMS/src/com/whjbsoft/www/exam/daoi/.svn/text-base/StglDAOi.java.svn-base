package com.whjbsoft.www.exam.daoi;

import java.util.List;

import com.whjbsoft.www.exam.dao.StglDAO;
import com.whjbsoft.www.exam.po.Stgls;
import com.whjbsoft.www.exam.po.Tkgls;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class StglDAOi extends HibernateDaoSupport implements StglDAO {

	public StglDAOi() {

	}

	public int count(String con, Object... params) {
		StringBuffer sb = new StringBuffer(
				"select count(A) from Stgls A where 1=1");
		sb.append(con);
		return this.getHibernate_Template().count(sb.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Stgls.class, id);
	}

	public List getObjects(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	/**
	 * 修改了信息查询字段信息，添加了new
	 * com.whjbsoft.www.exam.po.Stgl(...)字符串，目的在于列表显示试题题目信息时不能过长
	 */
	public List getPageinfo(String con, int curpage, int pagerecord,
			Object... params) {
		StringBuffer sb = new StringBuffer(
				"select new com.whjbsoft.www.exam.po.Stgls(A.stzj, A.tkgl, A.stmc, A.stlx,A.stnyd, A.xxa, A.xxb,A.xxc,A.xxd,A.xxe,A.xxf,A.zqda,A.ckda) from Stgls A where 1=1");
		sb.append(con);
		return this.getHibernate_Template().getObjects(sb.toString(), curpage,
				pagerecord, params);
	}

	public Stgls getStgl(int id) {
		return (Stgls) this.getHibernate_Template().get(Stgls.class, id);
	}

	public List getTkxxs(String con, Object... params) {
		StringBuffer sb = new StringBuffer("from Tkgls A where 1=1");
		sb.append(con);
		return this.getHibernate_Template().getObjects(sb.toString(), params);
	}

	public void save(Stgls stgl) throws Exception {
		this.getHibernate_Template().save(stgl);
	}

	public void update(Stgls stgl) throws Exception {
		this.getHibernate_Template().merge(stgl);
	}

	public Tkgls getTkgl(int id) {
		return (Tkgls) this.getHibernate_Template().get(Tkgls.class, id);
	}

}
