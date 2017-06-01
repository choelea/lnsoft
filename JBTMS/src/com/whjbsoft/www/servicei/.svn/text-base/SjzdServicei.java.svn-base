package com.whjbsoft.www.servicei;

import java.io.File;
import java.util.List;
import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.SjzdDAO;
import com.whjbsoft.www.daoi.SjzdDAOi;
import com.whjbsoft.www.po.Hpxx;
import com.whjbsoft.www.po.Sjzdmx;
import com.whjbsoft.www.service.SjzdService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class SjzdServicei extends HibernateDaoSupport implements SjzdService {
	private SjzdDAO dao;
	public SjzdServicei() {
		this.setDao(new SjzdDAOi());
	}
	public SjzdDAO getDao() {
		return dao;
	}
	public void setDao(SjzdDAO dao) {
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
	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try{
			int count = this.getDao().count(con, params);
			List list = this.getDao().list(con, curpage, pagerecord, params);
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
	public List getSjzdList(String con, Object... params) {
		try{	
			return this.getDao().getSjzdmxs(con, params);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}

	}
	public Sjzdmx getSjzdmx(int id) {
		try{
			Sjzdmx sjzdmx = this.getDao().getSjzdmx(id);
			Hibernate.initialize(sjzdmx.getSjzd());
			return sjzdmx;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean nameExist(String hql, Object... params) {
		try{
			List list = this.getDao().getObjects(hql, params);
			return list.isEmpty()?false:true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean save(Sjzdmx sjzdmx) {
		try{	
			this.getHibernate_Template().beginTran();
			this.getDao().save(sjzdmx);
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
	public boolean update(Sjzdmx sjzdmx) {
		try{	
			this.getHibernate_Template().beginTran();
			this.getDao().update(sjzdmx);
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
	public boolean delHp(String[] ids) {
		try{
			this.getHibernate_Template().beginTran();
				for (String string : ids) {
					this.getDao().delete(Hpxx.class,Integer.parseInt(string));
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
	public Hpxx getHpxx(int id) {
		try{	
			return this.getDao().getHpxx(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public Pageinfo getHpxxPage(String con, int curpage, Object... params) {
		try{
			int count = this.getDao().goodsCount(con, params);
			List list = this.getDao().goodsList(con, curpage, pagerecord, params);
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
	public boolean save(Hpxx hpxx) {
		try{	
			this.getHibernate_Template().beginTran();
			this.getDao().save(hpxx);
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
	public boolean update(Hpxx hpxx) {
		try{	
			this.getHibernate_Template().beginTran();
			this.getDao().update(hpxx);
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
	public Pageinfo getPageinfo(String countHql, String hql, int curpage,int pagesize, Object... params) {
		try{
			int count = this.getDao().allCount(countHql, params);
			List list = this.getDao().getPageinfo(hql, curpage, pagesize, params);
			Pageinfo pageinfo = new Pageinfo(count,pagesize,list);
			pageinfo.setCurpage(curpage);
			return pageinfo;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
}
