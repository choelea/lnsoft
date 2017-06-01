package com.whjbsoft.www.servicei;

import java.util.List;

import com.whjbsoft.www.dao.BmxxDAO;
import com.whjbsoft.www.daoi.BmxxDAOi;
import com.whjbsoft.www.po.Bmxx;
import com.whjbsoft.www.service.BmxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class BmxxServicei extends HibernateDaoSupport implements BmxxService {
	private BmxxDAO dao;
	public BmxxServicei() {
		this.setDao(new BmxxDAOi());
	}
	public BmxxDAO getDao() {
		return dao;
	}
	public void setDao(BmxxDAO dao) {
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
	
	public Bmxx getBmxx(int id) {
		try{
			Bmxx bmxx = this.getDao().getBmxx(id);
			return bmxx;
		}catch(Exception e){
			e.printStackTrace();
			return null;
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
	public boolean save(Bmxx bmxx) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().save(bmxx);
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
	public boolean update(Bmxx bmxx) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().update(bmxx);
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
	public boolean isExist(String con, Object... params) {
		try{
			List list = this.getDao().getObjects(con, params);
			return list.isEmpty()?false:true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
}
