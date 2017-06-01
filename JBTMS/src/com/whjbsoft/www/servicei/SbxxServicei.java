package com.whjbsoft.www.servicei;

import java.util.List;

import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.SbxxDAO;
import com.whjbsoft.www.daoi.SbxxDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Sbxx;
import com.whjbsoft.www.service.SbxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class SbxxServicei extends HibernateDaoSupport implements SbxxService{
	private SbxxDAO dao;
	public SbxxDAO getDao() {
		return dao;
	}

	public void setDao(SbxxDAO dao) {
		this.dao = dao;
	}
	public SbxxServicei() {
		dao = new SbxxDAOi();
	}

	public boolean delete(String[] pks, int djzj, int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : pks) {
				this.getDao().delete(Integer.parseInt(string));
			}
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return false;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	

	public Pageinfo getPageinfo(String con, int curpage, Object... params) {
		try {
			String hql = "select new com.whjbsoft.www.vo.SbxxVo(A.sbzj,A.sbbh,B.kfmc,A.sblx,A.sbzt,A.dllx,A.ssxs,A.sssysz) from Sbxx A inner join A.kfxx B where 1=1 " + con;
			String countHql = "select count(*) from Sbxx A where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count(countHql, params);
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

	public Pageinfo getPageinfo(int djzj, int ktzj, String con, int curpage, Object... params) {
		try {
			this.getHibernate_Template().beginTran();
			String hql = "select new com.whjbsoft.www.vo.SbxxVo(A.sbzj,A.sbbh,B.kfmc,A.sblx,A.sbzt,A.dllx,A.ssxs,A.sssysz) from Sbxx A inner join A.kfxx B where 1=1 " + con;
			String countHql = "select count(*) from Sbxx A inner join A.kfxx B where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count(countHql, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
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

	public Sbxx getSbxx(int id) {
		try {
			Sbxx sbxx = this.getDao().getSbxx(id);
			Hibernate.initialize(sbxx.getKfxx());
			return sbxx;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Sbxx sbxx,int kfzj, int djzj, int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			Kfxx kfxx = new Kfxx();
			kfxx.setKfzj(kfzj);
			sbxx.setKfxx(kfxx);
			this.getDao().save(sbxx);
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
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

	public boolean update(Sbxx sbxx,int kfzj, int djzj, int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			Kfxx kfxx = new Kfxx();
			kfxx.setKfzj(kfzj);
			sbxx.setKfxx(kfxx);
			this.getDao().update(sbxx);
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
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