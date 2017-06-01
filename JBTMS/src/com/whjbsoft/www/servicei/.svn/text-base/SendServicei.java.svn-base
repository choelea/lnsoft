package com.whjbsoft.www.servicei;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import com.whjbsoft.www.dao.SendDAO;
import com.whjbsoft.www.daoi.SendDAOi;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.po.Ylxx;
import com.whjbsoft.www.po.Yscldd;
import com.whjbsoft.www.po.Ysddd;
import com.whjbsoft.www.po.Ysddxx;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.po.Ysrydd;
import com.whjbsoft.www.service.SendService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class SendServicei extends HibernateDaoSupport implements SendService{
	private SendDAO dao;
	public SendDAO getDao() {
		return dao;
	}

	public void setDao(SendDAO dao) {
		this.dao = dao;
	}
	public SendServicei() {
		dao = new SendDAOi();
	}

	public boolean delete(int djzj, int ktzj, String[] pks) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : pks) {
				Khht khht = this.getDao().getYspsdxx(Integer.parseInt(string)).getKhht();
				khht.setHtzt(0);
				this.getDao().delete(Integer.parseInt(string));
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(int djzj, int ktzj,String con,int curpage,Object...params) {
		try {
			this.getHibernate_Template().beginTran();
			String hql = "select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.zdsj,A.yszt,D.dwmc,E.dwmc,A.ssxs,A.sssysz) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E where 1=1 " + con;
			String countHql = "select count(*) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E  where 1=1" + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count(countHql, params);
			Pageinfo page = new Pageinfo(count,pagerecord,list);
			page.setCurpage(curpage);
			Dtxx dtxx = this.getDao().getDtxx(djzj,ktzj);
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
			String hql = "select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.zdsj,A.yszt,D.dwmc,E.dwmc) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E where 1=1 " + con;
			String countHql = "select count(*) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E  where 1=1" + con;
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

	public Yspsd getYspsdxx(int id) {
		try {
			Yspsd yspsd = this.getDao().getYspsdxx(id);
			Hibernate.initialize(yspsd.getKhht().getKhdd().getKhxxByKhzj());
			Hibernate.initialize(yspsd.getKhht().getKhdd().getKhxxByKhxKhzj());
			return yspsd;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(int djzj, int ktzj, Yspsd yspsd) {
		try {
			this.getHibernate_Template().beginTran();
			Khht khht = this.getDao().getKhht(yspsd.getKhht().getHtzj());
			//去除重复使用合同信息
			if("外包合同".equals(khht.getHtlx()) && khht.getHtzt()==2)
				return false;
			
			if("外包合同".equals(khht.getHtlx())) {
				khht.setHtzt(2);
			}else {
				khht.setHtzt(1);
			}
			this.getDao().save(yspsd);
			Dtxx dtxx = this.getDao().getDtxx(djzj,ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean update(int djzj, int ktzj, Yspsd yspsdxx) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(yspsdxx);
			Dtxx dtxx = this.getDao().getDtxx(djzj,ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
	public boolean task(int djzj, int ktzj, int ysdzj) {
		try {
			this.getHibernate_Template().beginTran();
			Yspsd yspsd = this.getDao().getYspsdxx(ysdzj);
			yspsd.setYszt(1);
			Dtxx dtxx = this.getDao().getDtxx(djzj,ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
	public boolean ddqs(int djzj,int ktzj,Yspsd yspsd) {
		try {
			String hq = " from Yspsd A where A.ysdzj = ?";
			Yspsd yspsdxx = (Yspsd) this.getDao().getObject(hq,yspsd.getYsdzj());
			List<Ysddd> list = new ArrayList<Ysddd>(yspsdxx.getYsddds());
			if(list != null && list.size()>0) {
				this.getHibernate_Template().beginTran();
				this.getDao().update(yspsd);
				Ysddd ysddd = list.get(0);
				Ysddxx ysddxx = ysddd.getYsddxx();
				if("运输".equals(yspsd.getYsdlx())) {
					Set<Ysrydd> ydry = ysddxx.getYsrydds();
					if(ydry != null && ydry.size()>0) {
						for (Ysrydd ysrydd : ydry) {
							Ygxx ygxx = (Ygxx) this.getDao().getObject(Ygxx.class, ysrydd.getId().getYgzj());
							ygxx.setYgzt("0");
						}
					}
					Set<Yscldd> ydcl = ysddxx.getYscldds();
					if(ydcl != null &&ydcl.size()>0) {
						for (Yscldd yscldd : ydcl) {
							Ylxx ylxx = (Ylxx) this.getDao().getObject(Ylxx.class, yscldd.getId().getYlzj());
							ylxx.setSyzt("空闲");
						}
					}
					ysddxx.setYsddzt(3);
				}else {
					String hql = "select count(A) from Yspsd A inner join A.ysddds B where B.ysddxx.ysddzj = ? and A.yszt = ?";
					int num = (Integer) this.getDao().getObject(hql, ysddd.getId().getYsddzj(),4);
					if(num == list.size()) {
						Set<Ysrydd> ydry = ysddxx.getYsrydds();
						if(ydry != null && ydry.size()>0) {
							for (Ysrydd ysrydd : ydry) {
								Ygxx ygxx = (Ygxx) this.getDao().getObject(Ygxx.class, ysrydd.getId().getYgzj());
								ygxx.setYgzt("0");
							}
						}
						Set<Yscldd> ydcl = ysddxx.getYscldds();
						if(ydcl != null &&ydcl.size()>0) {
							for (Yscldd yscldd : ydcl) {
								Ylxx ylxx = (Ylxx) this.getDao().getObject(Ylxx.class, yscldd.getId().getYlzj());
								ylxx.setSyzt("空闲");
							}
						}
						ysddxx.setYsddzt(3);
					}
				}
				Dtxx dtxx = this.getDao().getDtxx(djzj,ktzj);
				if(dtxx != null) {
					dtxx.setSfdt(1);
				}
				this.getHibernate_Template().commitTran();
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
}