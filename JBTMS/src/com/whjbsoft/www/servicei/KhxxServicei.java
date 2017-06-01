package com.whjbsoft.www.servicei;

import java.io.File;
import java.util.List;

import com.whjbsoft.www.dao.KhxxDAO;
import com.whjbsoft.www.daoi.KhxxDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khxx;
import com.whjbsoft.www.service.KhxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class KhxxServicei extends HibernateDaoSupport implements KhxxService{
	private KhxxDAO dao;
	public KhxxDAO getDao() {
		return dao;
	}

	public void setDao(KhxxDAO dao) {
		this.dao = dao;
	}
	public KhxxServicei(){
		dao = new KhxxDAOi();
	}

	public boolean delete(int dtzj, int stzj, String[] ids) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : ids) {
				this.getDao().delete(Integer.parseInt(string));
			}
			Dtxx dtxx = this.getDao().getDtxx(dtzj,stzj);
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

	public Khxx getKhxx(int id) {
		try {
			Khxx khxx = this.getDao().getKhxx(id);
			return khxx;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			String hql = " from Khxx A where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count("select count(*)" + hql, params);
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
			String hql = " from Khxx A where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count("select count(*)" + hql, params);
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

	public boolean khExist(String con, Object... params) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean save(int dtzj, int stzj, Khxx khxx) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(khxx);
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

	public boolean update(int dtzj, int stzj, Khxx khxx) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(khxx);
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