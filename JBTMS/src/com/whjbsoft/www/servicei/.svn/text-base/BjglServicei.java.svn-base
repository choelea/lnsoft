package com.whjbsoft.www.servicei;

import java.util.List;

import com.whjbsoft.www.dao.BjglDAO;
import com.whjbsoft.www.daoi.BjglDAOi;
import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Jsbj;
import com.whjbsoft.www.po.JsbjId;
import com.whjbsoft.www.service.BjglService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class BjglServicei extends HibernateDaoSupport implements BjglService {

	private BjglDAO dao;
	public BjglServicei(){
		dao =  new BjglDAOi();
	}
	
	/**
	 * @return the dao
	 */
	public BjglDAO getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(BjglDAO dao) {
		this.dao = dao;
	}

	public boolean delBjgl(String[] pk) {
		try {
			this.getHibernate_Template().beginTran();
			for(String id:pk){
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

	public Bjxx getBjgl(int pk) {
		try {
			Bjxx bjgl = this.getDao().getBjxx(pk);
			return bjgl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			int count = this.getDao().count(con, params);
			List list = this.getDao().getObjects(con, curpage, pagerecord, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean isExistBjgl(int sign, String fieldName, String fieldValue) {
		try {
			StringBuffer sb = new StringBuffer("from Bjxx where 1=1 ");
			sb.append(" and ").append(fieldName).append("=? ");
			if(sign!=0){
				sb.append(" and bjzj<>").append(sign);
			}
			List list = this.getDao().getObjects(sb.toString(), fieldValue);
			return !list.isEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Bjxx bjxx,int jsid) {
		try {
			this.getHibernate_Template().beginTran();
			bjxx.setBhzdz(1);
			this.getDao().save(bjxx);
			Jsbj bjjs = new Jsbj();
			JsbjId bjjsid = new JsbjId();
			bjjsid.setBjzj(bjxx.getBjzj());
			bjjs.setBjxx(bjxx);
			bjjsid.setJxzj(jsid);
			bjjs.setId(bjjsid);
			bjxx.getJsbjs().add(bjjs);
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

	public boolean update(Bjxx bjgl) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(bjgl);
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
	
}
