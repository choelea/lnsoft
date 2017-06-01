package com.whjbsoft.www.servicei;

import java.util.List;

import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.GgxxDAO;
import com.whjbsoft.www.daoi.GgxxDAOi;
import com.whjbsoft.www.po.Ggxx;
import com.whjbsoft.www.service.GgxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class GgxxServicei extends HibernateDaoSupport implements GgxxService {
	private GgxxDAO dao;
	public GgxxServicei() {		
		this.setDao(new GgxxDAOi());
	}
	
	public GgxxDAO getDao() {
		return dao;
	}

	public void setDao(GgxxDAO dao) {
		this.dao = dao;
	}

	public boolean delete(String[] ids) {
		try{
			this.getHibernate_Template().beginTran();
				for (String string : ids) {
					this.getDao().delete(Integer.parseInt(string));
				}
			this.getHibernate_Template().commitTran();
			return true;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Ggxx getGgxx(int id) {
		try{
			Ggxx ggxx = this.getDao().getGgxx(id);
			Hibernate.initialize(ggxx.getBjxx());
			return ggxx;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		StringBuffer countHql = new StringBuffer("select count(A) from Ggxx A inner join A.bjxx B inner join B.jsbjs C where 1 = 1 and C.jsgl.jxzj = ?");
		countHql.append(con);
		StringBuffer hql = new StringBuffer("select A from Ggxx A inner join fetch A.bjxx B inner join B.jsbjs C where 1 = 1 and C.jsgl.jxzj = ?");
		hql.append(con);
		try{
			int count = this.getDao().count(countHql.toString(), params);
			List list = this.getDao().list(hql.toString(), curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			pageinfo.setCurpage(curpage);
			return pageinfo;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Ggxx ggxx) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().save(ggxx);			
			this.getHibernate_Template().commitTran();			
			return true;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean update(Ggxx ggxx) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().update(ggxx);			
			this.getHibernate_Template().commitTran();			
			return true;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

//	public Pageinfo getClaPagedata(String con, int curpage, Object... params) {
//		StringBuffer countHql = new StringBuffer("select count(A) from Bjxx A where 1 = 1");
//		countHql.append(con);
//		StringBuffer hql = new StringBuffer("select new com.whjbsoft.www.vo.BjglVo(A.bjzj,A.bjbh,A.bjmc) from Bjxx A where 1 = 1");
//		hql.append(con);
//		try{
//			int count = this.getDao().count(countHql.toString(), params);
//			List list = this.getDao().list(hql.toString(), curpage, pagerecord, params);
//			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
//			pageinfo.setCurpage(curpage);
//			return pageinfo;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}finally{
//			this.getHibernate_Template().closeSession();
//		}
//	}
	
	public Pageinfo getClaPagedata(String con, int curpage, Object... params) {
		StringBuffer countHql = new StringBuffer("select count(A) from Bjxx A inner join A.jsbjs B inner join B.jsgl C where 1 = 1");
		countHql.append(con);
		StringBuffer hql = new StringBuffer("select new com.whjbsoft.www.vo.BjglVo(A.bjzj,A.bjbh,A.bjmc) from Bjxx A inner join A.jsbjs B inner join B.jsgl C where 1 = 1");
		hql.append(con);
		try{
			int count = this.getDao().count(countHql.toString(), params);
			List list = this.getDao().list(hql.toString(), curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			pageinfo.setCurpage(curpage);
			return pageinfo;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getGgxxPagedata(String con, int curpage, Object... params) {
		StringBuffer countHql = new StringBuffer("select count(A) from Ggxx A where 1 = 1");
		countHql.append(con);
		StringBuffer hql = new StringBuffer("select new com.whjbsoft.www.vo.GgxxVo(A.ggzj,A.bjxx.bjzj,A.ggbt,A.ggzz,A.ggnr,A.fbsj) from Ggxx A where 1 = 1");
		hql.append(con);
		try{
			int count = this.getDao().count(countHql.toString(), params);
			List list = this.getDao().list(hql.toString(), curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			pageinfo.setCurpage(curpage);
			return pageinfo;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
}
