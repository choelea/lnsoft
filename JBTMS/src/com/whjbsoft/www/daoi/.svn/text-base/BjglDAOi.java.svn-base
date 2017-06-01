/**
 * 
 */
package com.whjbsoft.www.daoi;

import java.util.List;

import com.whjbsoft.www.dao.BjglDAO;
import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Jsgl;
import com.whjbsoft.www.util.HibernateDaoSupport;

/**
 * @author whjb
 * @Date 2009-9-24 ÏÂÎç05:48:29
 */
public class BjglDAOi extends HibernateDaoSupport implements BjglDAO {

	/**
	 * @see org.whjbsoft.ems.dao.BjglDAO#count(java.lang.String,
	 *      java.lang.Object[])
	 */
	public int count(String con, Object... params) {
		StringBuffer sb = new StringBuffer("select count(A) from Bjxx A inner join A.jsbjs B inner join B.jsgl C where 1=1 ");
		sb.append(con);
		return this.getHibernate_Template().count(sb.toString(), params);
	}

	/**
	 * @see org.whjbsoft.ems.dao.BjglDAO#delete(int)
	 */
	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Bjxx.class, id);
	}

	/**
	 * @see org.whjbsoft.ems.dao.BjglDAO#getBjgl(int)
	 */
	public Bjxx getBjxx(int id) {
		return (Bjxx) this.getHibernate_Template().get(Bjxx.class, id);
	}

	/**
	 * @see org.whjbsoft.ems.dao.BjglDAO#getObjects(java.lang.String, int, int,
	 *      java.lang.Object[])
	 */
	public List getObjects(String con, int curpage, int pagerecord,
			Object... params) {
		StringBuffer sb = new StringBuffer("select new com.whjbsoft.www.vo.BjglVo(A.bjzj,A.bjbh,A.bjmc,C.jxzj,C.jsmc) from Bjxx A inner join A.jsbjs B inner join B.jsgl C where 1=1 ");
		return this.getHibernate_Template().getObjects(sb.append(con).toString(), curpage, pagerecord, params);
	}

	/**
	 * @see org.whjbsoft.ems.dao.BjglDAO#getObjects(java.lang.String,
	 *      java.lang.Object[])
	 */
	public List getObjects(String hql, Object... params) {
		return this.getHibernate_Template().getObjects(hql, params);
	}

	/**
	 * @see org.whjbsoft.ems.dao.BjglDAO#save(org.whjbsoft.ems.po.Bjgl)
	 */
	public void save(Bjxx bjxx) throws Exception {
		this.getHibernate_Template().save(bjxx);
	}

	/**
	 * @see org.whjbsoft.ems.dao.BjglDAO#update(org.whjbsoft.ems.po.Bjgl)
	 */
	public void update(Bjxx bjxx) throws Exception {
		this.getHibernate_Template().update(bjxx);
	}

	public Jsgl getJsgl(int id) {
		return (Jsgl) this.getHibernate_Template().get(Jsgl.class, id);
	}

}
