package com.whjbsoft.www.servicei;

import java.util.List;

import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.dao.YgxxDAO;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.daoi.YgxxDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.service.YgxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class YgxxServicei extends HibernateDaoSupport implements YgxxService {
	
	private YgxxDAO dao ;
	private DjxxDAO ddao;
	
	
	
	/**
	 * @return the ddao
	 */
	public DjxxDAO getDdao() {
		return ddao;
	}

	/**
	 * @param ddao the ddao to set
	 */
	public void setDdao(DjxxDAO ddao) {
		this.ddao = ddao;
	}

	/**
	 * 
	 */
	public YgxxServicei() {
		this.setDao(new YgxxDAOi());
		this.setDdao(new DjxxDAOi());
	}

	public boolean delYgxx(int djzj,int stzj,String[] pk) {
		try {
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
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

	public Ygxx getYgxx(int pk) {
		try {
			return this.getDao().getYgxx(pk);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	

	public Pageinfo getPagedata(String con, int djzj,int stzj,int curpage, Object... params) {
		try {
			this.getHibernate_Template().beginTran();
			if(stzj!=0){
				Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
				if(dtxx!=null){
					dtxx.setSfdt(1);
				}
			}
			String countHql = "select count(A) from Ygxx A where 1=1 and (A.ssxs = ? or A.ssxs = 0) and (A.sssysz = ? or A.sssysz = 0) ";
			int count = this.getDao().count(countHql+con, params);
			String listHql = " select A from Ygxx A where 1=1 and (A.ssxs = ? or A.ssxs = 0) and (A.sssysz = ? or A.sssysz = 0) ";
			List list = this.getDao().list(listHql+con, curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			pageinfo.setCurpage(curpage);
			this.getHibernate_Template().commitTran();
			return pageinfo;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(int djzj,int stzj,Ygxx ygxx) {
		try {
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
			this.getDao().save(ygxx);
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

	public boolean update(int djzj,int stzj,Ygxx ygxx) {
		try {
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
			this.getDao().update(ygxx);
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

	/**
	 * @return the dao
	 */
	public YgxxDAO getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(YgxxDAO dao) {
		this.dao = dao;
	}

}
