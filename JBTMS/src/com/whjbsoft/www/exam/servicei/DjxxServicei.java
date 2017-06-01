package com.whjbsoft.www.exam.servicei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.whjbsoft.www.exam.dao.DjxxDAO;
import com.whjbsoft.www.exam.dao.KsszDAO;
import com.whjbsoft.www.exam.dao.SjxxDAO;
import com.whjbsoft.www.exam.daoi.DjxxDAOi;
import com.whjbsoft.www.exam.daoi.KsszDAOi;
import com.whjbsoft.www.exam.daoi.SjxxDAOi;
import com.whjbsoft.www.exam.po.Djxxs;
import com.whjbsoft.www.exam.po.Sjtxs;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.service.DjxxService;
import com.whjbsoft.www.exam.vo.SjxxVo;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class DjxxServicei extends HibernateDaoSupport implements DjxxService {
	private DjxxDAO dao;
	private KsszDAO kdao;
	private SjxxDAO sdao;
	public DjxxServicei() {
		this.setDao(new DjxxDAOi());
		this.setKdao(new KsszDAOi());
		this.setSdao(new SjxxDAOi());
	}
	public KsszDAO getKdao() {
		return kdao;
	}
	public void setKdao(KsszDAO kdao) {
		this.kdao = kdao;
	}
	public DjxxDAO getDao() {
		return dao;
	}
	public void setDao(DjxxDAO dao) {
		this.dao = dao;
	}
	public SjxxDAO getSdao() {
		return sdao;
	}
	public void setSdao(SjxxDAO sdao) {
		this.sdao = sdao;
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
	public Djxxs get(int id) {
		try{
			Djxxs djxx = this.getDao().getDjxx(id);
			Hibernate.initialize(djxx.getSjxx());
			Hibernate.initialize(djxx.getXsxx());
			return djxx;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public Sjxxs getSjxx(int id) {
		try{
			return this.getSdao().getSjxx(id);
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
	
	public Pageinfo getSyszPage(String con, int curpage, Object... params) {
		try{
			int count = this.getKdao().count(con, params);
			List list = this.getKdao().getPageinfo(con, curpage, pagerecord, params);
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
	//试卷主键查询试卷详细信息（构建试卷展现页面）
	public List<SjxxVo> getSjst(int id) {
		try{
			List<SjxxVo> listVo = new ArrayList<SjxxVo>();
			Sjxxs sjxx = this.getSdao().getSjxx(id);
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
	
	public List<SjxxVo> getDjst(int id) {
		try{
			List<SjxxVo> listVo = new ArrayList<SjxxVo>();
			Djxxs djxx = this.getDao().getDjxx(id);
			Sjxxs sjxx = djxx.getSjxx();
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
					String hql = "select A,B,C from Dtxxs A left join A.id.stgl B left join A.id.djxx C where B.stlx=? and C.djzj=?";
					List stlist = this.getDao().getObjects(hql,sjtx.getSjtxmc(),djxx.getDjzj());					
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
	public boolean save(Djxxs djxx) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().save(djxx);
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
	public boolean update(Djxxs djxx) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().update(djxx);
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
	public static void main(String[] args) {
		DjxxServicei s = new DjxxServicei();
		List list = s.getDjst(1);
	}
}
