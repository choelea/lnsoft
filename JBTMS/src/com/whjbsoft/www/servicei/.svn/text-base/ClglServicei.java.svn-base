package com.whjbsoft.www.servicei;

import java.util.List;

import com.whjbsoft.www.dao.ClglDAO;
import com.whjbsoft.www.daoi.ClglDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Ylxx;
import com.whjbsoft.www.service.ClglService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class ClglServicei extends HibernateDaoSupport implements ClglService{
	private ClglDAO dao;
	public ClglDAO getDao() {
		return dao;
	}

	public void setDao(ClglDAO dao) {
		this.dao = dao;
	}
	public ClglServicei() {
		dao = new ClglDAOi();
	}

	public boolean delete(String[] pks,int djzj,int ktzj) {
		try {
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
			this.getHibernate_Template().beginTran();
			for (String string : pks) {
				this.getDao().delete(Integer.parseInt(string));
			}
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}


	public Pageinfo getPageinfo1(String con, int curpage,int djzj,int ktzj, Object... params) {
		try {
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
			this.getHibernate_Template().beginTran();
			String hql = " from Ylxx where 1=1 " + con;
			List list = this.getDao().getObjects(hql, curpage, pagerecord, params);
			int count = this.getDao().count("select count(*) " + hql, curpage, pagerecord, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			page.setCurpage(curpage);
			this.getHibernate_Template().commitTran();
			return page;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
	public Pageinfo getPageinfo(String con, int curpage,Object... params) {
		try {
			
			String hql = " from Ylxx where 1=1 " + con;
			List list = this.getDao().getObjects(hql, curpage, pagerecord, params);
			int count = this.getDao().count("select count(*) " + hql, curpage, pagerecord, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Ylxx getYlxx(int id) {
		try {
			Ylxx ylxx = this.getDao().getYlxx(id);
			return ylxx;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Ylxx ylxx,int djzj,int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(ylxx);
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
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean update(Ylxx ylxx,int djzj,int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(ylxx);
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
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

}
