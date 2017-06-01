/**
 * 
 */
package com.whjbsoft.www.daoi;

import java.io.Serializable;
import java.util.List;

import com.whjbsoft.www.dao.TestSetupDAO;
import com.whjbsoft.www.po.Sjxx;
import com.whjbsoft.www.po.Sysz;
import com.whjbsoft.www.po.Xsgwxx;
import com.whjbsoft.www.po.XsgwxxId;
import com.whjbsoft.www.util.HibernateDaoSupport;

/**
 * @author whjb
 *
 */
public class TestSetupDAOi extends HibernateDaoSupport implements TestSetupDAO {

	public void delete(int id) throws Exception {
		this.getHibernate_Template().delete(Sysz.class, id);
	}

	public Sjxx getSjxx(int id) {
		return (Sjxx)this.getHibernate_Template().get(Sjxx.class, id);
	}

	public List list(String hql, int curpage, int pagerecord, Object... params) {
		return this.getHibernate_Template().getObjects(hql, curpage, pagerecord,  params);
	}

	public void save(Sysz sysz) throws Exception {
		this.getHibernate_Template().save(sysz);
	}

	public int count(String hql, Object... params) {
		return this.getHibernate_Template().count(hql, params);
	}

	public void update(Sysz sysz) throws Exception {
		this.getHibernate_Template().update(sysz);
	}
	
	public List getTestInfo(String hql,Object...params){
		List list  = this.getHibernate_Template().getObjects(hql,params);
		return list;
	}

	public Sysz getSysz(int id) {		
		return (Sysz)this.getHibernate_Template().get(Sysz.class, id);
	}
//	删除学生岗位信息
	public void deleteXsgw(int id) throws Exception {
		String hql = "delete from Xsgwxx A where A.id.xsxx.xszj = "+id;
		this.getHibernate_Template().delete(hql);
	}

	public void update(Xsgwxx xsgwxx) throws Exception {
		this.getHibernate_Template().merge(xsgwxx);
	}
	public void save(Xsgwxx xsgwxx) throws Exception {
		this.getHibernate_Template().save(xsgwxx);
	}
	public void delete(Serializable id) throws Exception {
		XsgwxxId gwid = (XsgwxxId)id;
		String hql = "delete from Xsgwxx A where A.id.xsxx.xszj = "+gwid.getXsxx().getXszj()+" and A.id.gwxx.gwzj="+gwid.getGwxx().getGwzj();
		this.getHibernate_Template().delete(hql);
	}
}
