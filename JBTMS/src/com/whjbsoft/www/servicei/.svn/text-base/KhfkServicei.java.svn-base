package com.whjbsoft.www.servicei;

import java.util.List;

import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.KhfkDAO;
import com.whjbsoft.www.daoi.KhfkDAOi;
import com.whjbsoft.www.po.Khfk;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.service.KhfkService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class KhfkServicei extends HibernateDaoSupport implements KhfkService{
	private KhfkDAO dao;
	public KhfkDAO getDao() {
		return dao;
	}
	public void setDao(KhfkDAO dao) {
		this.dao = dao;
	}
	public KhfkServicei(){
		dao = new KhfkDAOi();
	}
	public boolean delete(String[] pks) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : pks) {
				this.getDao().getKhfk(Integer.parseInt(string)).getYspsd().setSffd(0);
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

	

	public Khfk getKhfk(int id) {
		try {
			Khfk khfk = this.getDao().getKhfk(id);
			Hibernate.initialize(khfk.getYspsd());
			return khfk;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPageinfo(String con,int curpage,Object... params) {
		try {
			String hql = " from Khfk A where 1=1 " + con;
			int count = this.getDao().count("select count(*)" + hql, params);
			List list = this.getDao().list(hql, params);
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

	public boolean save(Khfk khfk) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(khfk);
			Yspsd yspsd = (Yspsd) this.getDao().getObject(Yspsd.class,khfk.getYspsd().getYsdzj());
			yspsd.setSffd(1);
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

	public boolean update(Khfk khfk) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(khfk);
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
