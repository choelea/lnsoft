package com.whjbsoft.www.exam.servicei;

import java.util.List;

import com.whjbsoft.www.exam.dao.StglDAO;
import com.whjbsoft.www.exam.daoi.StglDAOi;
import com.whjbsoft.www.exam.po.Stgls;
import com.whjbsoft.www.exam.po.Tkgls;
import com.whjbsoft.www.exam.service.StglService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class StglServicei extends HibernateDaoSupport implements StglService{
	private StglDAO dao;
	public StglServicei() {
		this.setDao(new StglDAOi());
	}
	public StglDAO getDao() {
		return dao;
	}
	public void setDao(StglDAO dao) {
		this.dao = dao;
	}
	public boolean delete(String[] ids) {
		try{
			this.getHibernate_Template().beginTran();
			for (String string : ids) {
				this.getDao().delete(Integer.valueOf(string));
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
	public Stgls get(int id) {
		try{
			return this.getDao().getStgl(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	public List getObjects(String con, Object... params) {
		try{
			return this.getDao().getObjects(con, params);
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
	public List getTkgldata(String con, Object... params) {
		try{			
			return this.getDao().getTkxxs(con, params);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean isExist(String hql, Object... params) {
		try{
			List list = this.getDao().getObjects(hql,params);
			return list.isEmpty()?false:true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean save(Stgls stgl) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().save(stgl);
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
	public boolean update(Stgls stgl) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().update(stgl);
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
	public Tkgls getTkgl(int id) {
		try{
			return this.getDao().getTkgl(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

}
