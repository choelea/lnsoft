package com.whjbsoft.www.servicei;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.dao.KfxxDAO;
import com.whjbsoft.www.dao.YkddDAO;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.daoi.KfxxDAOi;
import com.whjbsoft.www.daoi.YkddDAOi;
import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Ykdd;
import com.whjbsoft.www.po.Ykmx;
import com.whjbsoft.www.service.YkddService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class YkddServicei extends HibernateDaoSupport implements YkddService {
	private YkddDAO dao;
	private DjxxDAO ddao;
	private KfxxDAO kdao;
	public YkddServicei() {
		this.setDao(new YkddDAOi());
		this.setDdao(new DjxxDAOi());
		this.setKdao(new KfxxDAOi());
	}

	public YkddDAO getDao() {
		return dao;
	}

	public void setDao(YkddDAO dao) {
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

	public Ykdd getYkdd(int id) {
		try{
			return this.getDao().getYkdd(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(int djzj, int stzj, Ykdd ykdd) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().save(ykdd);
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

	public boolean update(int djzj, int stzj, Ykdd ykdd) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			Ykdd vo = this.getDao().getYkdd(ykdd.getYkzj());
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			//以下是为了在不删除原有记录的情况下，修改明细信息，有可能导致的结果是所有记录没有执行删除但都执行了修改操作
			Set set1 = vo.getYkmxes();
			Set set2 = ykdd.getYkmxes();
			List list1 = new ArrayList(set1);
			List list2 = new ArrayList(set2);
			int list1Size = list1.size();
			int list2Size = list2.size();
			if(list1Size<list2Size){
				for(int i=0;i<list1Size;i++){
					Ykmx ykmx1= (Ykmx)list1.get(i);
					Ykmx ykmx2= (Ykmx)list2.get(i);
					ykmx2.setYkmxzj(ykmx1.getYkmxzj());
				}
			}else{
				for(int i=0;i<list2Size;i++){
					Ykmx ykmx1= (Ykmx)list1.get(i);
					Ykmx ykmx2= (Ykmx)list2.get(i);
					ykmx2.setYkmxzj(ykmx1.getYkmxzj());
				}
			}
			//清除无用数据
			set1.clear();
			//修改移库订单信息
			this.getDao().update(ykdd);
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

	public boolean ykczState(int djzj,int stzj,int id) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			Ykdd ykdd = this.getDao().getYkdd(id);
			Set set = ykdd.getYkmxes();			
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			if(set!=null && !set.isEmpty()){
				List<Ykmx> list = new ArrayList(set);
				for (Ykmx ykmx : list) {
					Cwxx cwxx1 = ykmx.getCwxxByCwzj();
					Cwxx cwxx2 = ykmx.getCwxxByCwxCwzj();
					cwxx1.setHgsl(cwxx1.getHgsl()-ykmx.getYkhpsl());
					cwxx1.setShsl(cwxx1.getShsl()-ykmx.getYkshsl());
					cwxx2.setHgsl(cwxx2.getHgsl()+ykmx.getYkhpsl());
					cwxx2.setShsl(cwxx2.getShsl()+ykmx.getYkshsl());
				}
				ykdd.setYkzt(1);
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

}
