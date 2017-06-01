package com.whjbsoft.www.servicei;

import java.io.File;
import java.util.List;

import com.whjbsoft.www.dao.HzgxxxDAO;
import com.whjbsoft.www.daoi.HzgxxxDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Hzgxxx;
import com.whjbsoft.www.service.HzgxxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class HzgxxxServicei extends HibernateDaoSupport implements HzgxxxService{
	private HzgxxxDAO dao;
	public HzgxxxDAO getDao() {
		return dao;
	}

	public void setDao(HzgxxxDAO dao) {
		this.dao = dao;
	}
	public HzgxxxServicei() {
		dao = new HzgxxxDAOi();
	}

	public boolean delete(int dtzj, int stzj, String[] ids) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : ids) {
				this.getDao().delete(Integer.parseInt(string));
			}
			Dtxx dtxx = this.getDao().getDtxx(dtzj, stzj);
			if(dtxx != null){
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

	public Hzgxxx getHzgxxx(int id) {
		try {
			Hzgxxx hzgxxx = this.getDao().getHzgxxx(id);
			return hzgxxx;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			String hql = " from Hzgxxx A where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count("select count(*) " + hql, params);
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

	public Pageinfo getPagedata(int dtzj, int stzj, String con, int curpage, Object... params) {
		try {
			this.getHibernate_Template().beginTran();
			String hql = " from Hzgxxx A where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count("select count(*) " + hql, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			Dtxx dtxx = this.getDao().getDtxx(dtzj, stzj);
			if(dtxx != null){
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

	public boolean hzgxExist(String con, Object... params) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean save(int dtzj, int stzj, Hzgxxx hzgxxx) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(hzgxxx);
			Dtxx dtxx = this.getDao().getDtxx(dtzj, stzj);
			if(dtxx != null){
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

	public boolean update(int dtzj, int stzj, Hzgxxx hzgxxx) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(hzgxxx);
			Dtxx dtxx = this.getDao().getDtxx(dtzj, stzj);
			if(dtxx != null){
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
