package com.whjbsoft.www.servicei;

import java.util.List;

import com.whjbsoft.www.dao.JsglDAO;
import com.whjbsoft.www.daoi.JsglDAOi;
import com.whjbsoft.www.po.Jsgl;
import com.whjbsoft.www.service.JsglService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class JsglServicei extends HibernateDaoSupport implements JsglService {

	private JsglDAO dao;

	public JsglServicei() {
		dao = new JsglDAOi();
	}

	public boolean delJsgl(String[] pk) {
		try {
			this.getHibernate_Template().beginTran();
			for (String id : pk) {
				this.getDao().delete(Integer.parseInt(id));
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


	public boolean isExist(String hql, Object... params) {
		try {
			List list = this.getDao().getObjects(hql, params);
			return !(list == null || list.isEmpty());
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Jsgl getJsgl(int pk) {
		try {
			Jsgl jsgl = this.getDao().getJsgl(pk);
			return jsgl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			String coutnHql = "select count(*) from Jsgl where 1=1";
			int count = this.getDao().count(coutnHql + con, params);
			String listHql = "from Jsgl where 1=1 ";
			List list = this.getDao().getObjects(listHql + con, curpage,
					pagerecord, params);
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

	public boolean isExistJsgl(int sign, String fieldName, String fieldValue) {
		try {
			StringBuffer sb = new StringBuffer("from Jsgl where 1=1");
			sb.append(" and ").append(fieldName).append("=?");
			if (sign != 0) {
				sb.append(" and jxzj <>").append(sign);
			}
			List list = this.getDao().getObjects(sb.toString(), fieldValue);
			return !list.isEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Jsgl jsgl) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(jsgl);
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

	public boolean update(Jsgl jsgl) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(jsgl);
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

	/**
	 * @return the dao
	 */
	public JsglDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(JsglDAO dao) {
		this.dao = dao;
	}

}
