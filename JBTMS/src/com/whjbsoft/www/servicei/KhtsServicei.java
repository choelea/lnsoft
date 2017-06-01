package com.whjbsoft.www.servicei;

import java.io.File;
import java.util.List;

import com.whjbsoft.www.dao.KhtsDAO;
import com.whjbsoft.www.daoi.KhtsDAOi;
import com.whjbsoft.www.po.Khts;
import com.whjbsoft.www.service.KhtsService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class KhtsServicei extends HibernateDaoSupport implements KhtsService {

	private KhtsDAO dao ;
	
	
	
	/**
	 * 
	 */
	public KhtsServicei() {
		this.setDao(new KhtsDAOi());
	}

	public boolean delete(String[] ids) {
		try {
			this.getHibernate_Template().beginTran();
			for(String id:ids){
				this.getDao().delete(Integer.parseInt(id));
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

	public Khts getKhts(int id) {
		try {
			return this.getDao().getKhts(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			String countHql = "select count(A) from Khts A where 1=1 and (A.ssxs=? and A.sssysz=? or A.ssxs=0 and A.sssysz=0) ";
			String listHql = "select A from Khts A where 1=1 and A.ssxs=? and A.sssysz=? ";
			int count = this.getDao().count(countHql+con, params);
			List list =  this.getDao().list(listHql+con+" order by A.tszj desc", curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			return pageinfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Khts khts) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(khts);
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

	public boolean update(Khts khts) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(khts);
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

	public KhtsDAO getDao() {
		return dao;
	}

	public void setDao(KhtsDAO dao) {
		this.dao = dao;
	}

}
