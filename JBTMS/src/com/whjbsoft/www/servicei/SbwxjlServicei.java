package com.whjbsoft.www.servicei;

import java.util.List;

import com.whjbsoft.www.dao.SbwxjlDAO;
import com.whjbsoft.www.daoi.SbwxjlDAOi;
import com.whjbsoft.www.po.Sbwxjlb;
import com.whjbsoft.www.service.SbwxjlService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class SbwxjlServicei extends HibernateDaoSupport implements SbwxjlService{
	private SbwxjlDAO dao;
	public SbwxjlServicei() {
		this.setDao(new SbwxjlDAOi());
	}
	public SbwxjlDAO getDao() {
		return dao;
	}
	public void setDao(SbwxjlDAO dao) {
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
	
	public Pageinfo getPageinfo(String con, int curpage, Object... params) {
		try{
			int count = this.getDao().count(con, params);
			List list = this.getDao().getPageinfo(con, curpage, pagerecord, params);
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
	public Sbwxjlb getSbwxjlb(int id) {
		try{
			Sbwxjlb sbwxjl = this.getDao().getSbwxjlb(id);
			return sbwxjl;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean save(Sbwxjlb sbwxjl) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().save(sbwxjl);
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
	public boolean update(Sbwxjlb sbwxjl) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().update(sbwxjl);
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

}
