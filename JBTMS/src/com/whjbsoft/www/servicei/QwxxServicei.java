package com.whjbsoft.www.servicei;

import java.util.List;
import java.util.Random;

import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.dao.KfxxDAO;
import com.whjbsoft.www.dao.QwxxDAO;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.daoi.KfxxDAOi;
import com.whjbsoft.www.daoi.QwxxDAOi;
import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Qwxx;
import com.whjbsoft.www.service.QwxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class QwxxServicei extends HibernateDaoSupport implements QwxxService {
	private QwxxDAO dao;
	private DjxxDAO ddao;
	private KfxxDAO kdao;
	public QwxxServicei() {
		this.setDao(new QwxxDAOi());
		this.setDdao(new DjxxDAOi());
		this.setKdao(new KfxxDAOi());
	}
	public QwxxDAO getDao() {
		return dao;
	}
	public void setDao(QwxxDAO dao) {
		this.dao = dao;
	}
	public DjxxDAO getDdao() {
		return ddao;
	}
	public void setDdao(DjxxDAO ddao) {
		this.ddao = ddao;
	}
	public KfxxDAO getKdao() {
		return kdao;
	}
	public void setKdao(KfxxDAO kdao) {
		this.kdao = kdao;
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
	public Qwxx getQwxx(int id) {
		try{
			Qwxx qwxx = this.getDao().getQwxx(id);
			Hibernate.initialize(qwxx.getKfxx());
			return qwxx;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean isExist(String con, Object... params) {
		try{
			List list = this.getDao().getObjects(con, params);
			return list.isEmpty()?false:true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean save(int djzj, int stzj, Qwxx qwxx) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().save(qwxx);
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
	public boolean update(int djzj, int stzj, Qwxx qwxx) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().update(qwxx);
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
	
	public void setDtxx(int djzj, int stzj) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getHibernate_Template().commitTran();			
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();			
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public Kfxx getKfxx(int id) {
		try{
			return this.getKdao().getKfxx(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean saveCwxx(int djzj, int stzj, Qwxx qwxx) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			String no = createTxm();
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			Qwxx qw = this.getDao().getQwxx(qwxx.getQwzj());
			int arow = qwxx.getAmhs();//A行数
			int acol = qwxx.getAmls();//A列数	
			qw.setAmhs(arow);
			qw.setAmls(acol);
			for(int i=0;i<arow;i++){				
				for(int j=0;j<acol;j++){
					Cwxx cwxx = new Cwxx();
					cwxx.setCwbh("A"+(i+1)+"-"+(j+1));
					cwxx.setCwsx(0.0);
					cwxx.setCwtm(no+(createNum(i)+createNum(j)));
					cwxx.setCwzfm("A");
					cwxx.setHgsl(0.0);
					cwxx.setQwxx(qwxx);
					cwxx.setShsl(0.0);
					this.getDao().save(cwxx);
				}
			}
			if(qw.getQfabm()!=0){
				no = createTxm();
				int brow = qwxx.getBmhs();//B行数
				int bcol = qwxx.getBmls();//B列数
				qw.setBmhs(brow);
				qw.setBmls(bcol);
				for(int i=0;i<brow;i++){
					for(int j=0;j<bcol;j++){
						Cwxx cwxx = new Cwxx();
						cwxx.setCwbh("B"+(i+1)+"-"+(j+1));
						cwxx.setCwsx(0.0);
						cwxx.setCwtm(no+(createNum(i+1)+createNum(j+1)));
						cwxx.setCwzfm("B");
						cwxx.setHgsl(0.0);
						cwxx.setQwxx(qwxx);
						cwxx.setShsl(0.0);
						this.getDao().save(cwxx);
					}
				}			
			}
			qw.setSffpcw(1);//是否分配储位
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
	private String createTxm(){
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int i = r.nextInt(1000000000);
		while(i<100000000){
			i = r.nextInt(1000000000);
		}
		sb.append(i);
		return sb.toString();
	}
	private String createNum(int num){
		StringBuffer sb = new StringBuffer();
		if(num<10)
			sb.append("0").append(num);
		else
			sb.append(num);
		return sb.toString();
	}
	public boolean update(Cwxx cwxx) {
		try{
			this.getHibernate_Template().beginTran();			
			this.getDao().update(cwxx);
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
	public boolean resetCwxx(Cwxx cwxx) {
		try{
			this.getHibernate_Template().beginTran();
			Cwxx cw = this.getDao().getCwxx(cwxx.getCwzj());
			cw.setCwsx(cwxx.getCwsx());
			cw.setHpbm(cwxx.getHpbm());
			cw.setHpmc(cwxx.getHpmc());
			cw.setHpdw(cwxx.getHpdw());
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
	public List getCwxxList(String con,Object... params) {
		try{
			return this.getDao().getCwlist(con,params);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

}
