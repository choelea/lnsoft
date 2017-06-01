package com.whjbsoft.www.servicei;

import java.util.List;

import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.dao.KfxxDAO;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.daoi.KfxxDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.service.KfxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class KfxxServicei extends HibernateDaoSupport implements KfxxService {
	private KfxxDAO dao;
	private DjxxDAO ddao;
	public KfxxServicei() {
		this.setDao(new KfxxDAOi());
		this.setDdao(new DjxxDAOi());
	}
	public KfxxDAO getDao() {
		return dao;
	}
	public void setDao(KfxxDAO dao) {
		this.dao = dao;
	}
	public DjxxDAO getDdao() {
		return ddao;
	}
	public void setDdao(DjxxDAO ddao) {
		this.ddao = ddao;
	}
	public boolean delete(int djzj,int stzj,String[] ids) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
				if(dtxx!=null){
					dtxx.setSfdt(1);
				}
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
	
	public Kfxx getKfxx(int id) {
		try{
			return this.getDao().getKfxx(id);
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
	
	public Pageinfo getPageinfo(int djzj, int stzj, String con, int curpage, Object... params) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			int count = this.getDao().count(con, params);
			List list = this.getDao().getPageinfo(con, curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			pageinfo.setCurpage(curpage);
			this.getHibernate_Template().commitTran();
			return pageinfo;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return null;
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
	public boolean save(int djzj,int stzj,Kfxx kfxx) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().save(kfxx);
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
	public boolean update(int djzj,int stzj,Kfxx kfxx) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().update(kfxx);
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
