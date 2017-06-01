package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.XsglDAO;
import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class XsglDAOi extends HibernateDaoSupport implements XsglDAO {

	/**
	 * @see org.whjbsoft.ems.dao.XsglDAO#getObject(java.lang.String, java.lang.Object[])
	 */
	public Object getObject(String hql, Object... params) {
		return this.getHibernate_Template().get(hql, params);
	}

	public XsglDAOi() {
		
	}

	public int count(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select count(A) from Xsxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().count(hql.toString(), params);
	}

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Xsxx.class, id);
	}

	public List getObjects(String con, int curpage, int pagerecord, Object... params) {
		StringBuffer hql = new StringBuffer("from Xsxx A where 1 = 1");
		hql.append(con);
		return this.getHibernate_Template().getObjects(hql.toString(), curpage, pagerecord, params);
	}

	public List getObjects(String hql, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, params);
	}

	public Xsxx getXsgl(int id) {
		return (Xsxx)this.getHibernate_Template().get(Xsxx.class, id);
	}

	public Xsxx getXsgl(String userName, String paw) {
		String hql = "from Xsxx A where A.xsxh = ? and A.xsmm = ? and A.yxbj=1";		
		return (Xsxx)this.getHibernate_Template().get(hql, userName,paw);
	}

	public void save(Xsxx xsgl) throws Exception {
		this.getHibernate_Template().save(xsgl);
	}

	public void update(Xsxx xsgl) throws Exception {
		this.getHibernate_Template().merge(xsgl);
	}

	/**
	 * @see org.whjbsoft.ems.dao.XsglDAO#getBjgl(int)
	 */
	public Bjxx getBjgl(int id) {
		return (Bjxx) this.getHibernate_Template().get(Bjxx.class, id);
	}
	public List getStu(String hql, Object... params) {		
		return this.getHibernate_Template().getObjects(hql, params);
	}
}
