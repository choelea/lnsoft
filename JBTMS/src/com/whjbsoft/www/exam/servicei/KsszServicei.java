package com.whjbsoft.www.exam.servicei;

import java.util.List;

import com.whjbsoft.www.exam.dao.KsszDAO;
import com.whjbsoft.www.exam.daoi.KsszDAOi;
import com.whjbsoft.www.exam.po.Kssz;
import com.whjbsoft.www.exam.service.KsszService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class KsszServicei extends HibernateDaoSupport implements KsszService {
	private KsszDAO dao;

	public KsszServicei() {
		this.setDao(new KsszDAOi());
	}

	public KsszDAO getDao() {
		return dao;
	}

	public void setDao(KsszDAO dao) {
		this.dao = dao;
	}

	public boolean delete(String[] ids) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : ids) {
				this.getDao().delete(Integer.valueOf(string));
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Kssz get(int id) {
		try {
			return this.getDao().getKssz(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public List getObjects(String con, Object... params) {
		try {
			return this.getDao().getObjects(con, params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPageinfo(String con, int curpage, Object... params) {
		try {
			int count = this.getDao().count(con, params);
			List list = this.getDao().getPageinfo(con, curpage, pagerecord,
					params);
			Pageinfo pageinfo = new Pageinfo(count, pagerecord, list);
			pageinfo.setCurpage(curpage);
			return pageinfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Kssz kssz) {
		try {
			this.getHibernate_Template().beginTran();
			System.out.println(kssz.getBjxx().getBjzj());
			this.getDao().save(kssz);
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean update(Kssz kssz) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(kssz);
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean szState(int id, int state) {
		try {
			Kssz kssz = this.getDao().getKssz(id);
			this.getHibernate_Template().beginTran();
			if (state == 1) {
				List list = this.getDao().getObjects(
						"from Kssz A where A.bjxx.bjzj=? and A.ksszzt=?",
						kssz.getBjxx().getBjzj(), 1);
				for (int i = 0; i < list.size(); i++) {
					Kssz sz = (Kssz) list.get(i);
					sz.setKsszzt(0);
				}
			}
			kssz.setKsszzt(state);
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPageinfo(String countHql, String hql, int curpage,
			Object... params) {
		try {
			int count = this.getDao().countHql(countHql, params);
			List list = this.getDao().getPageHql(hql, curpage, pagerecord,
					params);
			Pageinfo pageinfo = new Pageinfo(count, pagerecord, list);
			pageinfo.setCurpage(curpage);
			return pageinfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

}
