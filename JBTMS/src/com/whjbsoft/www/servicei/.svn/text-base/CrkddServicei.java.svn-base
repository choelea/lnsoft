package com.whjbsoft.www.servicei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.CrkddDAO;
import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.dao.HtxxDAO;
import com.whjbsoft.www.daoi.CrkddDAOi;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.daoi.HtxxDAOi;
import com.whjbsoft.www.po.Ccrydd;
import com.whjbsoft.www.po.CcryddId;
import com.whjbsoft.www.po.Ccsbdd;
import com.whjbsoft.www.po.CcsbddId;
import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.po.Crkhp;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khddhpb;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Sbxx;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.service.CrkddService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.DdVo;

public class CrkddServicei extends HibernateDaoSupport implements CrkddService {
	

	

	private CrkddDAO dao;
	private DjxxDAO ddao;
	private HtxxDAO kdao;
	
	/**
	 * 
	 */
	public CrkddServicei() {
		this.setDao(new CrkddDAOi());
		this.setDdao(new DjxxDAOi());
		this.setKdao(new HtxxDAOi());
	}

	/**
	 * @return the dao
	 */
	public CrkddDAO getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(CrkddDAO dao) {
		this.dao = dao;
	}

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

	public boolean delCrkdd(int djzj, int stzj, String[] pk) {
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
		}catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Crkdd getCrkdd(int pk) {
		try {
			Crkdd crkdd = this.getDao().getCrkdd(pk);
			if(crkdd!=null&&crkdd.getKhht()!=null){
				Hibernate.initialize(crkdd.getKhht());
			}
			if(crkdd!=null&&crkdd.getCrkhps()!=null){
				Hibernate.initialize(crkdd.getCrkhps());
			}
			return crkdd;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public Crkdd getCrkddNoLazy(int pk) {
		try {
			Crkdd crkdd = this.getDao().getCrkdd(pk);
			return crkdd;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public DdVo getCrkddDdInfo(int pk) {
		try {
			Crkdd crkdd = this.getDao().getCrkdd(pk);
			DdVo ddvo = new DdVo();
			ddvo.setCrkdd(crkdd);
			if(crkdd.getCcrydds()!=null&&!crkdd.getCcrydds().isEmpty()){
				Iterator<Ccrydd> it = crkdd.getCcrydds().iterator();
				List ygList = new ArrayList();
				while(it.hasNext()){
					Ccrydd ydd = it.next();
					Ygxx ygxx = new Ygxx();
					BeanUtils.copyProperties(ygxx, ydd.getYgxx());
					ygList.add(ygxx);
				}
				ddvo.setYgList(ygList);
			}
			if(crkdd.getCcsbdds()!=null&&!crkdd.getCcsbdds().isEmpty()){
				Iterator<Ccsbdd> it = crkdd.getCcsbdds().iterator();
				List sbList = new ArrayList();
				while(it.hasNext()){
					Ccsbdd sdd = it.next();
					Sbxx sbxx = new Sbxx();
					BeanUtils.copyProperties(sbxx, sdd.getSbxx());
					sbList.add(sbxx);
				}
				ddvo.setSbList(sbList);
			}
			return ddvo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	

	public Pageinfo getPagedata(String con, int djzj, int stzj, int curpage,
			Object... params) {
		try {
			if(stzj!=0){
				Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
				if(dtxx!=null){
					dtxx.setSfdt(1);
				}
			}
			this.getHibernate_Template().beginTran();
			String countHql = "select count(A) from Crkdd A where 1=1 and A.ssxs =? and A.sssysz=? ";
			int count = this.getDao().count(countHql+con, params);
			String listHql = "select A from Crkdd A where 1=1 and A.ssxs =? and A.sssysz=? ";
			List list = this.getDao().list(listHql+con+" order by A.crkzj desc", curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
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

	public boolean save(int djzj, int stzj, Crkdd crkdd,String popk,String orderKind) {
		try {
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
			if(popk!=null){
				Khht khht = this.getKdao().getHtxx(Integer.parseInt(popk));
				khht.setHtzt(1);
				crkdd.setKhht(khht);
				if(orderKind!=null&&"rkdd".equals(orderKind)){//入库订单
					String hql = "from Khddhpb where khdd.ddzj=?";
					List<Khddhpb> list = this.getKdao().getHtxxs(hql, khht.getKhdd().getDdzj());
					for(Khddhpb h:list){
						Crkhp crkhp = new Crkhp();
						BeanUtils.copyProperties(crkhp, h);
						crkhp.setHgsl(0.0);
						crkhp.setShsl(0.0);
						crkhp.setCrkdd(crkdd);
						crkdd.getCrkhps().add(crkhp);
					}
				}else if(orderKind!=null&&"ckdd".equals(orderKind)){//出库订单
					List list = new ArrayList(khht.getCrkdds());
					if(list!=null&&!list.isEmpty()){
						Crkdd rkdd = (Crkdd) list.get(0);
						rkdd.setDdzt(6);
						if(rkdd.getCrkhps()!=null){
							Iterator it = rkdd.getCrkhps().iterator();
							while(it.hasNext()){
								Crkhp crkhp = new Crkhp();
								Crkhp rkhp  =  (Crkhp) it.next();
								BeanUtils.copyProperties(crkhp, rkhp);
								crkhp.setCrkdd(crkdd);
								crkhp.setCrkhpzj(null);
								crkhp.setCrkhps(null);
								crkdd.getCrkhps().add(crkhp);
							}
						}
					}
				}
			}
			this.getDao().save(crkdd);
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

	public boolean update(int djzj, int stzj, Crkdd crkdd) {
		try {
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
			this.getDao().update(crkdd);
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
	
	public String  getRkddbh(int htzj){
		try {
			String hql="select ddbh from Crkdd where khht.htzj=? and ddlx =?";
			List list = this.getKdao().getHtxxs(hql, htzj,"入库");
			if(list!=null&&!list.isEmpty()){
				return (String) list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean  Dd(int djzj, int stzj, int crkzj, String zjryzj, String[] ccryzj, String[] sbzj) {
		try {
			this.getHibernate_Template().beginTran();
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			if(dtxx!=null){
				dtxx.setSfdt(1);
			}
			Crkdd crkdd = this.getDao().getCrkdd(crkzj);
			crkdd.setDdzt(2);
			if(zjryzj!=null&&!"".equals(zjryzj)){
				Ygxx ygxx = this.getDao().getYgxx(Integer.parseInt(zjryzj));
				ygxx.setYgzt("1");
				CcryddId ccryddId = new CcryddId(crkzj,Integer.parseInt(zjryzj));
				Ccrydd ccrydd = new Ccrydd(ygxx,crkdd);
				ccrydd.setId(ccryddId);
				crkdd.getCcrydds().add(ccrydd);
				crkdd.setZjr(ygxx.getYgmc());
			}
			if(ccryzj!=null&&ccryzj.length>0){
				for(int i=0;i<ccryzj.length;i++){
					Ygxx ygxx = this.getDao().getYgxx(Integer.parseInt(ccryzj[i]));
					ygxx.setYgzt("1");
					CcryddId ccryddId = new CcryddId(crkzj,Integer.parseInt(ccryzj[i]));
					Ccrydd ccrydd = new Ccrydd(ygxx,crkdd);
					ccrydd.setId(ccryddId);
					crkdd.getCcrydds().add(ccrydd);
				}
			}
			if(sbzj!=null&&sbzj.length>0){
				for(int i=0;i<sbzj.length;i++){
					Sbxx sbxx = this.getDao().getSbxx(Integer.parseInt(sbzj[i]));
					sbxx.setSbzt("使用");
					CcsbddId ccsbddId = new CcsbddId(crkzj,Integer.parseInt(sbzj[i]));
					Ccsbdd ccsbdd = new Ccsbdd(sbxx,crkdd);
					ccsbdd.setId(ccsbddId);
					crkdd.getCcsbdds().add(ccsbdd);
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
	/**
	 * @return the kdao
	 */
	public HtxxDAO getKdao() {
		return kdao;
	}

	/**
	 * @param kdao the kdao to set
	 */
	public void setKdao(HtxxDAO kdao) {
		this.kdao = kdao;
	}
}
