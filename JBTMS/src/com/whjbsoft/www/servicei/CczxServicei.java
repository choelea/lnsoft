package com.whjbsoft.www.servicei;

import java.util.List;

import com.whjbsoft.www.dao.CczxDAO;
import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.daoi.CczxDAOi;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.po.Crkhp;
import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Sbxx;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.service.CczxService;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.Szcw;

public class CczxServicei extends HibernateDaoSupport implements CczxService {
	
	


	private CczxDAO dao;
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
	public CczxServicei() {
		super();
		this.setDao(new CczxDAOi());
		this.setDdao(new DjxxDAOi());
	}

	/**
	 * @return the dao
	 */
	public CczxDAO getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(CczxDAO dao) {
		this.dao = dao;
	}


	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			String countHql = "select count(A) from Crkdd A where 1=1 and A.ssxs =? and A.sssysz=? ";
			int count = this.getDao().count(countHql+con, params);
			String listHql = "select A from Crkdd A where 1=1 and A.ssxs =? and A.sssysz=? ";
			List list = this.getDao().list(listHql+con+" order by A.crkzj desc", curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			return pageinfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean zhijian(int djzj, int stzj, Crkdd vo, String[] hpzj, String[] hgsl) {
		try {
			this.getHibernate_Template().beginTran();
			if(stzj!=0){
				Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
				if(dtxx!=null){
					dtxx.setSfdt(1);
				}
			}
			if(hpzj!=null){
				for(int i=0;i<hpzj.length;i++){
					Crkhp crkhp = (Crkhp) this.getDao().getObject(Crkhp.class, Integer.parseInt(hpzj[i]));
					crkhp.setHgsl(Double.valueOf(hgsl[i]));
					crkhp.setShsl(crkhp.getHpsl()-Double.valueOf(hgsl[i]));
				}
			}
			String hql = "select A from Ygxx A inner join A.ccrydds B where B.id.crkzj=? and ygzw=?";
			List<Ygxx> list = this.getDao().getList(hql, vo.getCrkzj(),"质检员");
			if(list!=null&&!list.isEmpty()){
				for(Ygxx y:list){
					y.setYgzt("0");
				}
			}
			this.getDao().update(vo);
			Khht khht = (Khht) this.getDao().getObject(Khht.class, vo.getKhht().getHtzj());
			if("出库".equals(vo.getDdlx())){
				if(khht!=null){
					khht.setSfkyysps(1);
				}
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
	
	public boolean rkcz(int djzj, int stzj, int ddzj, List<Szcw> list) {
		try {
			this.getHibernate_Template().beginTran();
			if(stzj!=0){
				Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
				if(dtxx!=null){
					dtxx.setSfdt(1);
				}
			}
			Crkdd rkdd = (Crkdd) this.getDao().getObject(Crkdd.class, ddzj);
			if(rkdd.getDdzt()>4){
				return false;
			}
			for(Szcw s:list){
				String []cwzj = s.getCwzj();
				String []hgsl = s.getHgsl();
				String []shsl = s.getShsl();
				if(s.getCrkhpzj()!=null){
					Crkhp rkhp = (Crkhp) this.getDao().getObject(Crkhp.class, Integer.parseInt(s.getCrkhpzj()));
					rkhp.getCrkhps().clear();
					for(int i=0;i<cwzj.length;i++){
						if(cwzj[i]!=null){
							Cwxx cwxx = (Cwxx) this.getDao().getObject(Cwxx.class, Integer.parseInt(cwzj[i]));
							cwxx.setHgsl(cwxx.getHgsl()+Double.valueOf((hgsl[i]==null||"".equals(hgsl[i]))?"0":hgsl[i]));
							cwxx.setShsl(cwxx.getShsl()+Double.valueOf((shsl[i]==null||"".equals(shsl[i]))?"0":shsl[i]));
							rkhp.getCrkhps().add(cwxx);
						}
					}
				}
			}
			rkdd.setDdzt(5);
			rkdd.setSjcrksj(FormateDate.formate());
			String hql = "select A from Ygxx A inner join A.ccrydds B where B.id.crkzj=? and ygzw!=?";
			List<Ygxx> ygList = this.getDao().getList(hql, rkdd.getCrkzj(),"质检员");
			if(ygList!=null&&!ygList.isEmpty()){
				for(Ygxx y:ygList){
					y.setYgzt("0");
				}
			}
			
			hql="select A from Sbxx A inner join A.ccsbdds B where B.id.crkzj=? ";
			List<Sbxx> sbList = this.getDao().getList(hql, rkdd.getCrkzj());
			if(sbList!=null&&!sbList.isEmpty()){
				for(Sbxx s:sbList){
					s.setSbzt("空闲");
				}
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

	
	public boolean ckcz(int djzj, int stzj, int ddzj, List<Szcw> list) {
		try {
			this.getHibernate_Template().beginTran();
			if(stzj!=0){
				Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
				if(dtxx!=null){
					dtxx.setSfdt(1);
				}
			}
			Crkdd ckdd = (Crkdd) this.getDao().getObject(Crkdd.class, ddzj);
			if(ckdd.getDdzt()>3){
				return false;
			}
			for(Szcw s:list){
				String []cwzj = s.getCwzj();
				String []hgsl = s.getHgsl();
				String []shsl = s.getShsl();
				if(s.getCrkhpzj()!=null){
					Crkhp rkhp = (Crkhp) this.getDao().getObject(Crkhp.class, Integer.parseInt(s.getCrkhpzj()));
					rkhp.getCrkhps().clear();
					for(int i=0;i<cwzj.length;i++){
						if(cwzj[i]!=null){
							Cwxx cwxx = (Cwxx) this.getDao().getObject(Cwxx.class, Integer.parseInt(cwzj[i]));
							cwxx.setHgsl(cwxx.getHgsl()-Double.valueOf((hgsl[i]==null||"".equals(hgsl[i]))?"0":hgsl[i]));
							cwxx.setShsl(cwxx.getShsl()-Double.valueOf((shsl[i]==null||"".equals(shsl[i]))?"0":shsl[i]));
							rkhp.getCrkhps().add(cwxx);
						}
					}
				}
			}
			ckdd.setDdzt(4);
			ckdd.setSjcrksj(FormateDate.formate());
			String hql = "select A from Ygxx A inner join A.ccrydds B where B.id.crkzj=? and ygzw!=?";
			List<Ygxx> ygList = this.getDao().getList(hql, ckdd.getCrkzj(),"质检员");
			if(ygList!=null&&!ygList.isEmpty()){
				for(Ygxx y:ygList){
					y.setYgzt("0");
				}
			}
			
			hql="select A from Sbxx A inner join A.ccsbdds B where B.id.crkzj=? ";
			List<Sbxx> sbList = this.getDao().getList(hql, ckdd.getCrkzj());
			if(sbList!=null&&!sbList.isEmpty()){
				for(Sbxx s:sbList){
					s.setSbzt("空闲");
				}
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
}
