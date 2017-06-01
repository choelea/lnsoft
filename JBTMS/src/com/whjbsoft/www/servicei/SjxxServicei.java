package com.whjbsoft.www.servicei;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.whjbsoft.www.dao.SjxxDAO;
import com.whjbsoft.www.daoi.SjxxDAOi;
import com.whjbsoft.www.po.Sjhp;
import com.whjbsoft.www.po.Sjxx;
import com.whjbsoft.www.service.SjxxService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class SjxxServicei extends HibernateDaoSupport implements SjxxService {
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

	public boolean delete(String[] ids,Object...params) {
		try{
			this.getHibernate_Template().beginTran();
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

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		StringBuffer countHql = new StringBuffer("select count(A) from Sjxx A where 1 = 1");
		countHql.append(con);
		StringBuffer hql = new StringBuffer("from Sjxx A where 1 = 1");
		hql.append(con);
		try{
			int count = this.getDao().count(countHql.toString(), params);
			List list = this.getDao().list(hql.toString(), curpage, pagerecord, params);
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

	public Sjxx getSjxx(int id) {
		try{
			Sjxx sjxx = this.getDao().getSjxx(id);
			return sjxx;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Sjxx sjxx,Object...params) {
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().save(sjxx);
			Set set = (HashSet) params[0];
			for (Object object : set) {
				Sjhp sjhp = (Sjhp) object;
				this.getHibernate_Template().save(sjhp);
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

	public boolean update(Sjxx sjxx,Object...params) {
		StringBuffer sb = new StringBuffer("delete from Ktxx A where A.sjxx.sjzj = ");
		String hql = "delete from Sjhp A where A.sjxx.sjzj = " + sjxx.getSjzj();
		sb.append(sjxx.getSjzj());
		try{
			this.getHibernate_Template().beginTran();
			this.getDao().delete(sb.toString());
			this.getDao().delete(hql);
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
	
	public boolean updateKsnr(Sjxx sjxx) {
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
	
	public List getSjhp(int id) {
		List list = new ArrayList();
		String sjhql = "from Sjhp where sjzj = ?";
		String hphql = "from Hpxx where hpbm = ?";
		try{
			Sjxx sjxx = this.getDao().getSjxx(id);
			List sjhplist = this.getHibernate_Template().getObjects(sjhql, sjxx.getSjzj());
			List hpxxlist = new ArrayList();
			for (int i = 0; i < sjhplist.size(); i++) {
				Sjhp sjhp = (Sjhp) sjhplist.get(i);
				hpxxlist.add(this.getHibernate_Template().get(hphql,sjhp.getHpbm()));
			}
			list.add(sjxx);
			list.add(sjhplist);
			list.add(hpxxlist);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public List getSjhpVo(int sjzj){
		try {
			String hql = "select new com.whjbsoft.www.vo.SjhpVo(A.sjzj,C.hpbm,C.hpmc,B.hpsl) from Sjxx A ,Sjhp B , Hpxx C where A.sjzj=B.sjxx.sjzj and B.hpbm = C.hpbm and A.sjzj = ?";
			return this.getHibernate_Template().getObjects(hql, sjzj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public List getStglList(String con, Object... params) {		
		
		StringBuffer hql = new StringBuffer("from Stgl A where 1 = 1");
		hql.append(con);
		try{	
			return this.getDao().getSjxxs(hql.toString(), params);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public List getKtxxList(String con, Object... params) {
//		StringBuffer hql = new StringBuffer("select A from Ktxx A left join fetch A.stgl B where 1 = 1");
//		hql.append(con).append(" order by A.stgl.stsx");
		String hql ="select new com.whjbsoft.www.vo.KtxxVo(D.ftzj,E.stzj,E.stmc,E.stlx,D.ktfs,D.ktms,D.yksl,A.sfdt) from Dtxx A inner join A.djxx B  inner join B.sjxx C  inner join C.ktxxes D inner join D.stgl E where C.sjzj=? and B.djzj=? and A.ktzj=E.stzj order by E.stzj";
		try{	
			return this.getDao().getSjxxs(hql.toString(), params);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	public List getKtxxListFroAction(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select A from Ktxx A left join fetch A.stgl B where 1 = 1");
		hql.append(con).append(" order by B.stzj");
		try{	
			return this.getDao().getSjxxs(hql.toString(), params);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	public boolean nameExist(String con, Object... params) {
		StringBuffer hql = new StringBuffer("from Sjxx A where 1 = 1");
		hql.append(con);
		try{	
			List list = this.getDao().getSjxxs(hql.toString(), params);
			return list.isEmpty()?false:true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public void updateSjzt(int id, int state) {
		try{
			this.getHibernate_Template().beginTran();
			Sjxx sjxx = this.getDao().getSjxx(id);
			sjxx.setSjzt(state);
			this.getHibernate_Template().commitTran();			
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();			
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public String getKtlx(String ktlx) {	
		StringBuffer sb = new StringBuffer();
		if(ktlx.contains("0")){
			sb.append("基础资料").append(" ");
		}
		if(ktlx.contains("1")){
			sb.append("客户关系").append(" ");
		}
		if(ktlx.contains("2")){
			sb.append("仓储").append(" ");
		}
		if(ktlx.contains("3")){
			sb.append("订单").append(" ");
		}
		if(ktlx.contains("4")){
			sb.append("财务").append(" ");
		}
		if(ktlx.contains("5")){
			sb.append("决策").append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SjxxServicei ser = new SjxxServicei();
		String hql ="select new com.whjbsoft.www.vo.SjhpVo(A.sjzj,C.hpbm,C.hpmc,B.hpsl) from Sjxx A ,Sjhp B , Hpxx C where A.sjzj=B.sjxx.sjzj and B.hpbm = C.hpbm and A.sjzj = 4";
		ser.getHibernate_Template().getObjects(hql);
	}
	
	public Pageinfo getGoods(String con,int curpage,Object...params){
		try {
			String countHql = "select count(*) from Hpxx where 1=1 ";
			int count = this.getDao().count(countHql, params);
			String listHql = "from Hpxx where 1=1";
			List list = this.getDao().list(listHql, curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			return pageinfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
}
