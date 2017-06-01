package com.whjbsoft.www.servicei;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.BxglDAO;
import com.whjbsoft.www.daoi.BxglDAOi;
import com.whjbsoft.www.po.Bxlc;
import com.whjbsoft.www.po.Bxxx;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.service.BxglService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class BxglServicei extends HibernateDaoSupport implements BxglService{
	private BxglDAO dao;
	public BxglDAO getDao() {
		return dao;
	}
	public void setDao(BxglDAO dao) {
		this.dao = dao;
	}
	public BxglServicei(){
		dao = new BxglDAOi();
	}
	public boolean delete(String[] pks,int djzj,int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			for (String id : pks) {
				this.getDao().delete(Integer.parseInt(id));
			}
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Bxxx getBxgl(int id) {
		try {
			Bxxx bxgl = this.getDao().getBxgl(id);
			Hibernate.initialize(bxgl.getBxlcs());
			return bxgl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPageinfo1(String con, int curpage,int djzj,int ktzj, Object... params) {
		try {
			this.getHibernate_Template().beginTran();
			String hql = " from Bxxx where 1=1 " + con;
			List list = this.getDao().getObjects(hql,curpage,pagerecord, params);
			int count = this.getDao().count("select count(*) " + hql, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return page;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	public Pageinfo getPageinfo(String con, int curpage,Object... params) {
		try {
			String hql = " from Bxxx where 1=1 " + con;
			List list = this.getDao().getObjects(hql,curpage,pagerecord, params);
			int count = this.getDao().count("select count(*) " + hql, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Bxxx bxgl,String[] tcdq,String[] tccx,int djzj,int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			Set<Bxlc> bxxls = new HashSet<Bxlc>();
			if(tcdq != null){
				for (int i = 0;i<tcdq.length;i++) {
					Bxlc bxxl = new Bxlc();
					bxxl.setBxxx(bxgl);
					bxxl.setBxzd(tcdq[i]);
					bxxl.setTksx(Integer.parseInt(tccx[i]));
					bxxls.add(bxxl);
				}
				bxgl.setBxlcs(bxxls);
			}
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getDao().save(bxgl);
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean update(Bxxx bxgl,String[] tcdq,String[] tccx,int djzj,int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			Bxxx bx = this.getDao().getBxgl(bxgl.getBxzj());
			Set<Bxlc> bxxls = bx.getBxlcs();
			bxxls.clear();
			if(tcdq != null){
				for (int i = 0;i<tcdq.length;i++) {
					Bxlc bxxl = new Bxlc();
					bxxl.setBxxx(bxgl);
					bxxl.setBxzd(tcdq[i]);
					bxxl.setTksx(Integer.parseInt(tccx[i]));
					bxxls.add(bxxl);
				}
				bxgl.setBxlcs(bxxls);
			}
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getDao().update(bxgl);
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
}
