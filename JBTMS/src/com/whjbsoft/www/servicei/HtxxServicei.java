package com.whjbsoft.www.servicei;

import java.io.File;
import java.util.List;

import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.HtxxDAO;
import com.whjbsoft.www.daoi.HtxxDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.service.HtxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class HtxxServicei extends HibernateDaoSupport implements HtxxService{
	private HtxxDAO dao;
	public HtxxDAO getDao() {
		return dao;
	}

	public void setDao(HtxxDAO dao) {
		this.dao = dao;
	}
	public HtxxServicei() {
		dao = new HtxxDAOi();
	}

	public boolean delete(int dtzj, int stzj, String[] ids) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : ids) {
				Khdd khdd = this.getDao().getHtxx(Integer.parseInt(string)).getKhdd();
				khdd.setDdzt(1);
				this.getDao().delete(Integer.parseInt(string));
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

	public Khht getHtxx(int id) {
		try {
			Khht khht = this.getDao().getHtxx(id);
			Hibernate.initialize(khht.getKhdd());
			return khht;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			String hql = " from Khht A where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count("select count(*) " + hql, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			return page;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(int dtzj, int stzj, String con, int curpage, Object... params) {
		try {
			this.getHibernate_Template().beginTran();
			String hql = " from Khht A where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count("select count(*) " + hql, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			Dtxx dtxx = this.getDao().getDtxx(dtzj, stzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
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

	public boolean save(int dtzj, int stzj, Khht htxx) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(htxx);
			Khdd khdd = this.getDao().getKhdd(htxx.getKhdd().getDdzj());
			khdd.setDdzt(2);
			Dtxx dtxx = this.getDao().getDtxx(dtzj, stzj);
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

	public boolean update(int dtzj, int stzj, Khht htxx) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(htxx);
			Dtxx dtxx = this.getDao().getDtxx(dtzj, stzj);
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