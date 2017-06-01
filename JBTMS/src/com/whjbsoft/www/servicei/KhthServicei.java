package com.whjbsoft.www.servicei;

import java.util.List;

import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.KhthDAO;
import com.whjbsoft.www.daoi.KhthDAOi;
import com.whjbsoft.www.po.Khth;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.service.KhthService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class KhthServicei extends HibernateDaoSupport implements KhthService{
	private KhthDAO dao;
	public KhthDAO getDao() {
		return dao;
	}
	public void setDao(KhthDAO dao) {
		this.dao = dao;
	}
	public KhthServicei() {
		dao = new KhthDAOi();
	}
	public boolean delete(String[] pks) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : pks) {
				this.getDao().getKhth(Integer.parseInt(string)).getYspsd().setSfth(0);
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

	

	public Khth getKhth(int id) {
		try {
			Khth khth = this.getDao().getKhth(id);
			Hibernate.initialize(khth.getYspsd());
			return khth;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	public Pageinfo getPageinfo(String con, int curpage, Object... params) {
		try {
			String hql = "select new com.whjbsoft.www.vo.KhthVo(A.thzj,B.ysdbh,A.thdh,A.thrq,A.thrqm,A.fhzd) " +
			"from Khth A inner join A.yspsd B where 1=1 " + con;
			String countHql = "select count(*) from Khth A inner join A.yspsd B where 1=1" + con;
			int count = this.getDao().count(countHql, params);
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

	public boolean save(Khth khth) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(khth);
			Yspsd yspsd = (Yspsd) this.getDao().getObject(Yspsd.class,khth.getYspsd().getYsdzj());
			yspsd.setSfth(1);
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

	public boolean update(Khth khth) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(khth);
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
