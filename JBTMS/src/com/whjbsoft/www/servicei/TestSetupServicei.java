/**
 * 
 */
package com.whjbsoft.www.servicei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.whjbsoft.www.dao.TestSetupDAO;
import com.whjbsoft.www.dao.XsglDAO;
import com.whjbsoft.www.daoi.TestSetupDAOi;
import com.whjbsoft.www.daoi.XsglDAOi;
import com.whjbsoft.www.po.Gwxx;
import com.whjbsoft.www.po.Sjxx;
import com.whjbsoft.www.po.Sysj;
import com.whjbsoft.www.po.SysjId;
import com.whjbsoft.www.po.Sysz;
import com.whjbsoft.www.po.Xsgwxx;
import com.whjbsoft.www.po.XsgwxxId;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.service.TestSetupService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

/**
 * @author whjb
 * 
 */
public class TestSetupServicei extends HibernateDaoSupport implements
		TestSetupService {

	private TestSetupDAO dao;
	private XsglDAO sdao ;

	/**
	 * @return the sdao
	 */
	public XsglDAO getSdao() {
		return sdao;
	}

	/**
	 * @param sdao the sdao to set
	 */
	public void setSdao(XsglDAO sdao) {
		this.sdao = sdao;
	}

	public TestSetupServicei() {
		this.setDao(new TestSetupDAOi());
		this.setSdao(new XsglDAOi());
	}

	public TestSetupDAO getDao() {
		return dao;
	}

	public void setDao(TestSetupDAO dao) {
		this.dao = dao;
	}
	public Pageinfo getPageinfo(String countHql, String hql, int curpage, int pagerecord, Object... params) {
		try{
			int count = this.getDao().count(countHql, params);
			List list = this.getDao().list(hql, curpage, pagerecord, params);
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

	public List getSjxx(int syzj){
		try {
			String hql = "from Sjxx where syszs.syszzj =? order by sjzj";
			List<Sjxx> list = this.getDao().getTestInfo(hql, syzj);
			return list;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	/**
	 * 
	 * setCwhp
	 * @return
	 */
	public boolean  setCwhp(int hpsl){
		try {
			this.getHibernate_Template().beginTran();
			String hql ="update Ccsp set spsl= ? where cwzj=1";
			this.getHibernate_Template().update(hql, hpsl);
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
	

	public boolean setup(Integer claPk,String[] stuPks, int sjzj, String sjmc) {
		try{
			this.getHibernate_Template().beginTran();
			Sysz sysz = new Sysz();
			sysz.setCzrzj(0);
			sysz.setSyjxsj(0);
			sysz.setSyszmc("");
			sysz.setSyszzt(0);
			this.getDao().save(sysz);
			SysjId sysjId = new SysjId(sysz.getSyszzj(),sjzj);
			Sysj sysj = new Sysj();
			sysj.setId(sysjId);
			sysz.getSysjs().add(sysj);
			for (String pk : stuPks) {
				Xsxx xsxx = this.getSdao().getXsgl(Integer.parseInt(pk));
				xsxx.setSssysz(sysz.getSyszzj());
				xsxx.setZhsyrwmc(sjmc);
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
	
	public Pageinfo getClaPageinfo(String con, int curpage, Object... params) {
		StringBuffer countHql = new StringBuffer("select count(A) from Bjxx A inner join A.jsbjs B inner join B.jsgl C where 1=1 ");
		countHql.append(con);
		StringBuffer hql = new StringBuffer("select new com.whjbsoft.www.vo.BjglVo(A.bjzj,A.bjbh,A.bjmc,C.jxzj,C.jsmc) from Bjxx A inner join A.jsbjs B inner join B.jsgl C where 1=1 ");
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

	public Pageinfo getGroupPageinfo(String con, int curpage, Object... params) {
		//统计实验组数量
		StringBuffer countHql = new StringBuffer("select distinct(A.sssyz) from Xsxx A where 1=1 ");
		countHql.append(con);
		//统计实验组信息
		StringBuffer hql = new StringBuffer("select A.sssyz,B.bjmc,count(A.sssyz) from Xsxx A inner join A.bjxx B where 1 = 1");
		hql.append(con);
		hql.append(" group by A.sssyz,B.bjzj,B.bjmc");
		try{
			List countList = this.getDao().getTestInfo(countHql.toString(), params);
			int count = countList.size();//此处暂时没有办法提高效率。。此种方式效率很低
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
	
	public Pageinfo getXsxxPageinfo(String con, int curpage, Object... params) {
		StringBuffer countHql = new StringBuffer("select count(A) from Xsxx A where 1=1 ");
		countHql.append(con);
		StringBuffer hql = new StringBuffer("select A from Xsxx A where 1 = 1");
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
	
	public List getXsxxList(String con, Object... params) {
		StringBuffer hql = new StringBuffer("select A from Xsxx A where 1 = 1");
		hql.append(con);
		try{
			List list = this.getDao().getTestInfo(hql.toString(), params);
			for(int i=0;i<list.size();i++){
				Xsxx xsxx = (Xsxx)list.get(i);
				Set set = xsxx.getXsgwxxes();
				Iterator<Xsgwxx> iter = set.iterator();
				while (iter.hasNext()) {
					Xsgwxx xsgw = (Xsgwxx) iter.next();
					Gwxx gwxx = xsgw.getId().getGwxx();
					gwxx.getGwmc();
				}
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public List getRuleList() {
		try{
			List list = this.getDao().getTestInfo("from Gwxx A where 1 = 1");
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public void assignRule(int claPk, int groupSize) {
		try{
			String hql = "from Xsxx A where A.bjxx.bjzj = ?";
			int ruleCount = this.getDao().count("select count(A) from Gwxx A");
			this.getHibernate_Template().beginTran();
			List list = this.getDao().getTestInfo(hql,claPk);
			//添加试验设置记录
			Sysz sysz = new Sysz();
			this.getDao().save(sysz);
			
			int size = list.size();//总人数
//			满组情况下使用人数(可以分配的人数)
			size = size/groupSize*groupSize;
			for(int i=0;i<size;i++){
				Xsxx xsxx = (Xsxx)list.get(i);
				xsxx.setSssyz(i/groupSize+1);//实验组组号
				xsxx.setSssysz(sysz.getSyszzj());//所属实验设置
				//删除学生原有
				this.getDao().deleteXsgw(xsxx.getXszj());
				if(groupSize==1){
					for(int j=0;j<ruleCount;j++){
						Gwxx gwxx = new Gwxx();
						gwxx.setGwzj(j+1);
						Xsgwxx xsgw = new Xsgwxx(new XsgwxxId(gwxx,xsxx));
						xsxx.getXsgwxxes().add(xsgw);
					}					
				}else{
					Gwxx gwxx = new Gwxx();
					gwxx.setGwzj(i%ruleCount+1);//从1-ruleCount的权限
					Xsgwxx xsgw = new Xsgwxx(new XsgwxxId(gwxx,xsxx));
					xsxx.getXsgwxxes().add(xsgw);
				}
			}
			for(int i=size;i<list.size();i++){//剩余学生数量操作
				Xsxx xsxx = (Xsxx)list.get(i);
				xsxx.setSssyz(null);//实验组组号
				xsxx.setSssysz(null);
				this.getDao().deleteXsgw(xsxx.getXszj());
			}
			this.getHibernate_Template().commitTran();
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public void exchangeRule(int claPk, String[] gids) {
		try{
			String hql = "from Xsxx A where A.bjxx.bjzj=? and A.sssyz = ?";
			int ruleCount = this.getDao().count("select count(A) from Gwxx A");
			List list = null;
			this.getHibernate_Template().beginTran();
			for(int i=0;i<gids.length;i++){
				list = this.getDao().getTestInfo(hql,claPk,gids[i]);
				for(int j=0;j<list.size();j++){
					Xsxx xsxx = (Xsxx)list.get(j);
					Set set = xsxx.getXsgwxxes();
					List<Xsgwxx> temp = new ArrayList<Xsgwxx>(set);
//					this.getDao().deleteXsgw(xsxx.getXszj());
					if(temp!=null && !temp.isEmpty() && temp.size()!=ruleCount){
						for(int k=0;k<temp.size();k++){
							Xsgwxx xsgw = (Xsgwxx)temp.get(k);	
							boolean flag = false;
							boolean delFlag = false;
							for(int g=0;g<temp.size();g++){
								Xsgwxx xsgw2 = (Xsgwxx)temp.get(g);		
								if(xsgw.getId().getGwxx().getGwzj()%ruleCount+1==xsgw2.getId().getGwxx().getGwzj()){
									flag = true;
									break;
								}
							}
							for(int g=0;g<temp.size();g++){
								Xsgwxx xsgw2 = (Xsgwxx)temp.get(g);		
								if(xsgw.getId().getGwxx().getGwzj()==xsgw2.getId().getGwxx().getGwzj()%ruleCount+1){
									delFlag=true;
									break;
								}
							}
							if(!flag){
								Gwxx gwxx = new Gwxx();
								gwxx.setGwzj(xsgw.getId().getGwxx().getGwzj()%ruleCount+1);
								Xsgwxx xsgw1 = new Xsgwxx(new XsgwxxId(gwxx,xsxx));
								xsxx.getXsgwxxes().add(xsgw1);
							}
							if(!delFlag){
								this.getDao().delete(xsgw.getId());
							}
						}
					}
				}
			}
			this.getHibernate_Template().commitTran();
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}	

	public void handSetRule(int claPk, String[] stuIds) {
		try{
			String hql = "select max(A.sssyz) from Xsxx A where A.bjxx.bjzj = ?";
			int ruleCount = this.getDao().count("select count(A) from Gwxx A");
			Integer maxId = (Integer)this.getHibernate_Template().get(hql,claPk);
			if(maxId==null)
				maxId=0;
			this.getHibernate_Template().beginTran();
//			添加试验设置记录
			Sysz sysz = new Sysz();
			this.getDao().save(sysz);
			
			for(int i=0;i<stuIds.length;i++){
				Xsxx xsxx = this.getSdao().getXsgl(Integer.valueOf(stuIds[i]));
				xsxx.setSssyz(maxId+i+1);//实验组组号
				xsxx.setSssysz(sysz.getSyszzj());//所属实验设置
				//删除学生原有
				this.getDao().deleteXsgw(xsxx.getXszj());
				
				for(int j=0;j<ruleCount;j++){
					Gwxx gwxx = new Gwxx();
					gwxx.setGwzj(j+1);
					Xsgwxx xsgw = new Xsgwxx(new XsgwxxId(gwxx,xsxx));
					xsxx.getXsgwxxes().add(xsgw);
				}
			}
			this.getHibernate_Template().commitTran();
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public void resetRule(int id, String[] ruleIds) {
		try{
			this.getHibernate_Template().beginTran();
			Xsxx xsxx = this.getSdao().getXsgl(id);		
			this.getDao().deleteXsgw(xsxx.getXszj());
			
			for(int j=0;j<ruleIds.length;j++){
				Gwxx gwxx = new Gwxx();
				gwxx.setGwzj(Integer.valueOf(ruleIds[j]));
				Xsgwxx xsgw = new Xsgwxx(new XsgwxxId(gwxx,xsxx));
				xsxx.getXsgwxxes().add(xsgw);
			}
			this.getHibernate_Template().commitTran();
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public int countXsxx(int claPk) {
		String hql = "select count(A) from Xsxx A where 1 = 1 and A.bjxx.bjzj=?";
		try{
			int count = this.getDao().count(hql.toString(), claPk);
			return count;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean hasRule(int userId, int ruleId) {
		try{
			String hql = "from Xsgwxx A where A.id.xsxx.xszj=? and A.id.gwxx.gwzj=?";
			List list = this.getDao().getTestInfo(hql,userId,ruleId);
			return list.isEmpty()?false:true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}	
}
