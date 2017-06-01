package com.whjbsoft.www.servicei;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.dao.KfpdDAO;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.daoi.KfpdDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Kfcppdb;
import com.whjbsoft.www.po.Pddd;
import com.whjbsoft.www.service.KfpdService;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class KfpdServicei extends HibernateDaoSupport implements KfpdService {
	private KfpdDAO dao;
	private DjxxDAO ddao;
	public KfpdServicei() {
		this.setDao(new KfpdDAOi());
		this.setDdao(new DjxxDAOi());
	}

	public KfpdDAO getDao() {
		return dao;
	}

	public void setDao(KfpdDAO dao) {
		this.dao = dao;
	}
	public DjxxDAO getDdao() {
		return ddao;
	}

	public void setDdao(DjxxDAO ddao) {
		this.ddao = ddao;
	}

	public boolean delete(int djzj, int stzj, String[] ids) {
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

	public Pddd getPddd(int id) {
		try{
			return this.getDao().getPddd(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean pdczState(int djzj, int stzj, int id) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			Pddd pddd = this.getDao().getPddd(id);
			Date initDate = Date.valueOf(pddd.getPdrq());
			String paramDate = "";
			String paramDate1= "";
			Calendar c =Calendar.getInstance();
			c.setTime(initDate);
			//计算前一次盘点记录时间
			if("日盘点".equals(pddd.getPdlx())){		
				c.set(c.get(c.YEAR), c.get(c.MONTH),c.get(c.DATE)-1);
				paramDate=FormateDate.appointFormat("yyyy-MM-dd",c.getTime());
				paramDate1=pddd.getPdrq();
			}else if("月盘点".equals(pddd.getPdlx())){
				c.set(c.get(c.YEAR), c.get(c.MONTH)-1,c.get(c.DATE));
				paramDate=FormateDate.appointFormat("yyyy-MM",c.getTime());
				paramDate1=FormateDate.appointFormat("yyyy-MM",Date.valueOf(pddd.getPdrq()));
			}else if("年盘点".equals(pddd.getPdlx())){
				c.set(c.get(c.YEAR)-1, c.get(c.MONTH),c.get(c.DATE));
				paramDate=FormateDate.appointFormat("yyyy",c.getTime());
				paramDate1=FormateDate.appointFormat("yyyy",Date.valueOf(pddd.getPdrq()));
			}
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			String hql 	= "select A.hpbm,A.hpmc,sum(A.hgsl+A.shsl) from Cwxx A where A.qwxx.kfxx.kfzj=? and A.hpbm is not null group by A.hpbm,A.hpmc";
			List<Object[]> list = this.getDao().getObjects(hql,pddd.getSykfzj());
			Random r = new Random();
			int phtemp = r.nextInt(1000000);
			if(list!=null && !list.isEmpty()){
				for (Object[] objects : list) {
					Kfcppdb pdb = new Kfcppdb();
					pdb.setHpbm(String.valueOf(objects[0]));
					pdb.setHpmc(String.valueOf(objects[1]));
					pdb.setPddd(pddd);
//					pdb.setPh(FormateDate.appointFormat("yyMMdd",initDate));
					pdb.setPh(String.valueOf(phtemp));
					if(objects[2]!=null){
						pdb.setQmkc(Double.valueOf(String.valueOf(objects[2])));
					}else{
						pdb.setQmkc(0.0);
					}
					//期初盘点结果
					hql = "select A.qmkc from Kfcppdb A where A.pddd.ssxs=? and A.pddd.sssysz = ? and A.pddd.pdzt = 1 and A.pddd.pdrq like ? and A.hpbm = ? and A.hpmc = ? and A.pddd.sykfzj=?";
					List<Object> qckcs = this.getDao().getObjects(hql,pddd.getSsxs(),pddd.getSssysz(),paramDate+"%",objects[0],objects[1],pddd.getSykfzj());
					if(qckcs!=null && !qckcs.isEmpty()){
						Object qckc = qckcs.get(qckcs.size()-1);
						if(qckc==null){
							pdb.setQckc(0.0);
						}else{
							pdb.setQckc(Double.valueOf(String.valueOf(qckc)));
						}
					}else{
						pdb.setQckc(0.0);
					}
					//入库数量（状态为5表示执行入库操作）
					hql = "select sum(A.hgsl+A.shsl) from Crkhp A where A.crkdd.sjcrksj like ? and A.crkdd.ddlx = ? and A.crkdd.ssxs = ? and A.crkdd.sssysz = ? and A.crkdd.sykfzj =? and A.crkdd.ddzt > 4 and A.hpbm = ? and A.hpmc = ? group by A.hpbm,A.hpmc";
					qckcs = this.getDao().getObjects(hql, paramDate1+"%","入库",pddd.getSsxs(),pddd.getSssysz(),pddd.getSykfzj(),objects[0],objects[1]);
					if(qckcs!=null && !qckcs.isEmpty()){
						Object qckc = qckcs.get(qckcs.size()-1);
						if(qckc==null){
							pdb.setRksl(0.0);
						}else{
							pdb.setRksl(Double.valueOf(String.valueOf(qckc)));
						}
					}else{
						pdb.setRksl(0.0);
					}
					//出库数量（状态为5表示执行出库操作）
					qckcs = this.getDao().getObjects(hql, paramDate1+"%","出库",pddd.getSsxs(),pddd.getSssysz(),pddd.getSykfzj(),objects[0],objects[1]);
					if(qckcs!=null && !qckcs.isEmpty()){
						Object qckc = qckcs.get(qckcs.size()-1);
						if(qckc==null){
							pdb.setCksl(0.0);
						}else{
							pdb.setCksl(Double.valueOf(String.valueOf(qckc)));
						}
					}else{
						pdb.setCksl(0.0);
					}
					//计算盘盈和盘亏(期末库存减去入库数量加上出库数量跟期初库存比较)
					Double yk = pdb.getQmkc()-pdb.getRksl()+pdb.getCksl()-pdb.getQckc();
					if(yk>=0){
						pdb.setPysl(yk);
						pdb.setPksl(0.0);
					}else{
						pdb.setPysl(0.0);
						pdb.setPksl(yk);
					}
//					this.getDao().save(pdb);
					pddd.getKfcppdbs().add(pdb);
				}			
			}			
			pddd.setPdzt(1);
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

	public boolean save(int djzj, int stzj, Pddd pddd) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().save(pddd);
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

	public boolean update(int djzj, int stzj, Pddd pddd) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().update(pddd);
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
