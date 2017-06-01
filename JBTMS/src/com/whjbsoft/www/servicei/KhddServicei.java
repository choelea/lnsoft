package com.whjbsoft.www.servicei;

import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.KhddDAO;
import com.whjbsoft.www.daoi.KhddDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khddhpb;
import com.whjbsoft.www.service.KhddService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class KhddServicei extends HibernateDaoSupport implements KhddService{
	private KhddDAO dao;
	public KhddDAO getDao() {
		return dao;
	}

	public void setDao(KhddDAO dao) {
		this.dao = dao;
	}
	public KhddServicei() {
		dao = new KhddDAOi();
	}

	public boolean delete(int dtzj, int stzj, String[] ids) {
		try{
			this.getHibernate_Template().beginTran();
				Dtxx dtxx = this.getDao().getDtxx(dtzj,stzj);
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

	

	public Khdd getKhdd(int id) {
		try{
			Khdd khdd = this.getDao().getKhdd(id);
			Hibernate.initialize(khdd.getKhddhpbs());
			Hibernate.initialize(khdd.getKhxxByKhxKhzj());
			Hibernate.initialize(khdd.getKhxxByKhzj());
			return khdd;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(int dtzj, int stzj, String con, int curpage, Object... params) {
		try {
			this.getHibernate_Template().beginTran();
			String hql = "select new com.whjbsoft.www.vo.KhddVo(A.ddzj,B.dwmc,B.lxr,B.lxrdh,B.ssjg,C.dwmc,C.lxr,C.lxrdh,C.ssjg,A.ddbh,A.ddrq,A.qhrq,A.ddzt,A.zdr) from Khdd A inner join A.khxxByKhzj B inner join A.khxxByKhxKhzj C where 1=1 " + con ;
			String countHql = "select count(A) from Khdd A inner join A.khxxByKhzj B inner join A.khxxByKhxKhzj C where 1=1 " + con ;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count(countHql, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			Dtxx dtxx = this.getDao().getDtxx(dtzj, stzj);
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

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			String hql = "select new com.whjbsoft.www.vo.KhddVo(A.ddzj,B.dwmc,B.lxr,B.lxrdh,B.ssjg,C.dwmc,C.lxr,C.lxrdh,C.ssjg,A.ddbh,A.ddrq,A.qhrq,A.ddzt,A.zdr) from Khdd A inner join A.khxxByKhzj B inner join A.khxxByKhxKhzj C where 1=1 " + con ;
			String countHql = "select count(A) from Khdd A inner join A.khxxByKhzj B inner join A.khxxByKhxKhzj C where 1=1 " + con ;
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

	public List getList(String hql, Object... params) {
		try{
			return this.getDao().getObjects(hql, params);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(int dtzj, int stzj, Khdd khdd) {
		try{
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDao().getDtxx(dtzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
			this.getDao().save(khdd);
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

	public boolean update(int dtzj, int stzj, Khdd khddb) {
		try{
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDao().getDtxx(dtzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
			Khdd khdd = this.getDao().getKhdd(khddb.getDdzj());
			Set<Khddhpb> set = khdd.getKhddhpbs();
			khddb.setKhddhpbs(set);//表示不修改货品信息，否则，先清空货品信息，再重新加入
			BeanUtils.copyProperties(khdd, khddb);
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
	
	public boolean valiKhdd(int dtzj, int stzj, int ddzj) {
		try{
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDao().getDtxx(dtzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
			Khdd khdd = this.getDao().getKhdd(ddzj);
			khdd.setDdzt(1);
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