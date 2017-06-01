package com.whjbsoft.www.exam.servicei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.whjbsoft.www.exam.dao.SjxxDAO;
import com.whjbsoft.www.exam.daoi.SjxxDAOi;
import com.whjbsoft.www.exam.po.Sjtxs;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.service.SjxxService;
import com.whjbsoft.www.exam.vo.SjxxVo;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class SjxxServicei extends HibernateDaoSupport implements SjxxService{
	private SjxxDAO dao;
	public SjxxServicei() {
		this.setDao(new SjxxDAOi());
	}
	public SjxxDAO getDao() {
		return dao;
	}
	public void setDao(SjxxDAO dao) {
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
	public Sjxxs get(int id) {
		try{
			return this.getDao().getSjxx(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	public List getObjects(String hql, Object... params) {
		try{
			return this.getDao().getObjects(hql, params);
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
	public boolean save(Sjxxs sjxx) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().save(sjxx);
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
	public boolean update(Sjxxs sjxx) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().update(sjxx);
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
	public List<SjxxVo> getSjst(int id) {
		try{
			List<SjxxVo> listVo = new ArrayList<SjxxVo>();
			Sjxxs sjxx = this.getDao().getSjxx(id);
			//试卷题型
			Set<Sjtxs> set = sjxx.getSjtxes();
			//排序
			List<Sjtxs> list = new ArrayList<Sjtxs>(set);
			Collections.sort(list, new Comparator<Sjtxs>(){
				public int compare(Sjtxs o1, Sjtxs o2) {					
					return o1.getPlsx()-o2.getPlsx();
				}
			});
			//查询试题信息
			if(list!=null){
				for (Sjtxs sjtx : list) {
					String hql = "select A,B from Sjkts A left join A.id.stgl B where A.id.sjtx.sjtxzj=?";
					List stlist = this.getDao().getObjects(hql,sjtx.getSjtxzj());					
					listVo.add(new SjxxVo(sjtx,stlist));
				}
			}
			return listVo;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean sjState(int id, int sjzt) {
		try{
			Sjxxs sjxx = this.getDao().getSjxx(id);
			this.getHibernate_Template().beginTran();			
			sjxx.setSjzt(sjzt);
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
